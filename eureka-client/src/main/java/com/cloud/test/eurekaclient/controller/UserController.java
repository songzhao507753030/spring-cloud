package com.cloud.test.eurekaclient.controller;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date : 2019/12/19
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private EurekaClient eurekaClient;
    
    @GetMapping
    public String index(){
        var eureka = eurekaClient.getNextServerFromEureka("EUREKA-CLIENT-MASTER",false);
        return eureka.getHomePageUrl();
    }
    
    @GetMapping("/{id}")
    public String index(@PathVariable String id){
        return id;
    }
    
}
