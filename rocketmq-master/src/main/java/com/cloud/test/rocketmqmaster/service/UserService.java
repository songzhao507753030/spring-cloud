package com.cloud.test.rocketmqmaster.service;


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
}
