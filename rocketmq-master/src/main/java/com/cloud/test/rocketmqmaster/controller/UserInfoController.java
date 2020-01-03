package com.cloud.test.rocketmqmaster.controller;


import com.cloud.test.rocketmqmaster.AccountChangeEvent;
import com.cloud.test.rocketmqmaster.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@Log4j2
@RestController
public class UserInfoController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/transfer")
    public String transfer(@RequestParam("accountNo") String accountNo,@RequestParam("amount")Double amount){
        // 创建一个事务Id,作为消息内容发到MQ
        var tx_no = UUID.randomUUID().toString();
        var accountChangeEvent = new AccountChangeEvent(accountNo,amount,tx_no);
        userService.sendUpdateAccountBalace(accountChangeEvent);
        return "转账成功";
    }
    
}
