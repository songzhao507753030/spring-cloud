package com.cloud.test.configmaster.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date : 2019/12/20
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@RestController
public class UserController {
    
    @Value("${name}")
    private String name ;
    
    @Value("${email}")
    private String email ;
    
    @GetMapping("/name")
    public String index(){
        return name;
    }
    
    @GetMapping("/email")
    public String email(){
        return email;
    }
    
    
    
}
