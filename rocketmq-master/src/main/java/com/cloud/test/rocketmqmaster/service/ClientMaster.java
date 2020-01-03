package com.cloud.test.rocketmqmaster.service;


import com.cloud.test.rocketmqmaster.fallback.ClientMasterFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@FeignClient(name = "EUREKA-CLIENT-MASTER",path = "/eurekaClientMaster/user" ,fallback = ClientMasterFallback.class)
public interface ClientMaster {
    
    @GetMapping
    String index();
    
    @GetMapping("/{id}")
    String index( @PathVariable  String id);
    
}
