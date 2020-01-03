package com.cloud.test.rocketmqmaster.message;


import com.alibaba.fastjson.JSONObject;
import com.cloud.test.rocketmqmaster.AccountChangeEvent;
import com.cloud.test.rocketmqmaster.mapper.UserMapper;
import com.cloud.test.rocketmqmaster.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@Log4j2
@Component
@RocketMQMessageListener(consumerGroup = "consumer_group_txmsg_bank2",topic = "topic_txmsg")
public class TxmsgConsumer implements RocketMQListener<String> {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private UserService userService;
    
    //接受消息
    @Override
    public void onMessage(String msg){
        log.info("消息消费 :{} ",msg);
        //解析消息
        var jsonObject = JSONObject.parseObject(msg);
        var accountChange = jsonObject.getString("accountChange");
        var account = JSONObject.parseObject(accountChange,AccountChangeEvent.class);
        account.setAccountNo("2");
        //账号监听的是张三的，所以需要设置账号为李四的。
        //更新本地账户，增加金额
        userService.addAccountInfoBalance(account);
    }
}
