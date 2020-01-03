package com.cloud.test.rocketmqmaster.service;


import com.cloud.test.rocketmqmaster.AccountChangeEvent;

import java.util.List;
import java.util.Map;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 */
public interface UserService {
    
    List<Map<String, Object>> findUsers();
    
    //向mq发送转账消息
    public void sendUpdateAccountBalace(AccountChangeEvent accountChangeEvent);
    
    //更新账户金额。
    public void doUpdateAccountBalance(AccountChangeEvent accountChangeEvent);
    
}
