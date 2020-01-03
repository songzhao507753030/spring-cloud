package com.cloud.test.rocketmqmaster.service.impl;


import com.cloud.test.rocketmqmaster.mapper.UserMapper;
import com.cloud.test.rocketmqmaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String, Object>> findUsers(){
        return userMapper.selectUsers();
    }
}
