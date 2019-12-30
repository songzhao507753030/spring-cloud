package com.cloud.test.gateway.controller;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Date : 2019/12/30
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@RestController
public class Fallbackcontroller {
    
    @RequestMapping(value = "/fallbackcontroller")
    public Map<String, String> fallbackcontroller() {
        System.out.println("-------------fallbackController-------------");
        Map<String, String> res = new HashMap();
        res.put("code", "-100");
        res.put("data", "service not available");
        return res;
    }
    
    

}
