package com.cloud.test.rocketmqmaster;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountChangeEvent implements Serializable {
    
    /**
     * 账号
     */
    private String accountNo;
    
    /**
     * 变动金额
     */
    private double amount;
    
    /**
     * 事务号
     */
    private String txNo;
}
