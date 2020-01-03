package com.cloud.test.rocketmqmaster.service.impl;


import com.cloud.test.rocketmqmaster.AccountChangeEvent;
import com.cloud.test.rocketmqmaster.mapper.UserMapper;
import com.cloud.test.rocketmqmaster.service.UserService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 */
@Log4j2
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper  userMapper;
    
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public List<Map<String, Object>> findUsers(){
        return userMapper.selectUsers();
    }
    
    // mq 发送转账消息
    @Override
    public void sendUpdateAccountBalace(AccountChangeEvent account){
        
        // 将accountChangeEvent转成JSON
        var  json = new JSONObject();
        json.put("accountChange",account);
        var jsonObject = json.toJSONString();
        //主 message类型
        var build = MessageBuilder.withPayload(jsonObject).build();
        //发送一条事务信息
        /**
         * String txProducerGroup,  生产组
         * String destination topic,
         * Message<?> message, 消息内容
         * Object arg 参数
         */
        rocketMQTemplate.sendMessageInTransaction("producer_group_txmsg_bank1","topic_txmsg",build,null );
    }
    
    // 更新账户，扣减金额
    @Override
    @Transactional
    public void doUpdateAccountBalance(AccountChangeEvent account){
        // 幂等判断
        if(userMapper.isExistTx(account.getTxNo() )> 0  ){
            return;
        }
        //扣减金额
        userMapper.updateAccountBalance(account.getAccountNo(),account.getAccountNo() * -1);
        //添加事务日志
        account.addTx(account.getTxNo());
    }
}
