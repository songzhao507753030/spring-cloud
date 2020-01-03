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
    
    // 更新账户、增加金额
    public void addAccountInfoBalance(AccountChangeEvent accountChangeEvent);
    
}
