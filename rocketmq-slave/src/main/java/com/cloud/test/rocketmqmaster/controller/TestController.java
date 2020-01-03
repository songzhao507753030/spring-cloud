package com.cloud.test.rocketmqmaster.controller;


import com.cloud.test.rocketmqmaster.service.ClientMaster;
import com.cloud.test.rocketmqmaster.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 */
@RestController
@RequestMapping("/test")
@RefreshScope
@Log4j2
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    private ClientMaster clientMaster;

    @Value("${today}")
    private String name;

    @GetMapping
    public List<Map<String, Object>> findUsers(){
        System.out.println(name);
        log.info("today-----------> :{}",name);
        return  userService.findUsers();
    }
    
    @GetMapping("/client")
    public String index(){
        return clientMaster.index();
    }
    
    @GetMapping("/client/{id}")
    public String index(@PathVariable String id){
        return clientMaster.index(id);
    }

}
