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
    
    //增加金额。
    @Override
    @Transactional
    public void addAccountInfoBalance(AccountChangeEvent account){
        log.info("bank2更新本地账号，账号 :{},金额 :{}",account.getAccountNo(),account.getAmount());
        if(userMapper.isExistTx(account.getTxNo()) > 0 ){
            return;
        }
        // 增加金额 。 这个方法可会被重复调用
        userMapper.updateAccountBalance(account.getAccountNo(),account.getAmount());
        //添加事务记录，用户幂等
        userMapper.addTx(account.getTxNo());
        
    }
}
