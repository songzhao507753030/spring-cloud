package com.cloud.test.feignclientmaster.controller;


import com.cloud.test.feignclientmaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;

/**
 * Date : 2019/12/19
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public String index(){
        return userService.index();
    }
    
    @GetMapping("/{id}")
    public String index(@PathVariable String id){
        return userService.index(id);
    }
    
}
