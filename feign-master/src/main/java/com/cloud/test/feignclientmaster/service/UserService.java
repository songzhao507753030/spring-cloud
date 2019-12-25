package com.cloud.test.feignclientmaster.service;


import com.cloud.test.feignclientmaster.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Date : 2019/12/19
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@FeignClient(name = "EUREKA-CLIENT-MASTER",path = "/eurekaClientMaster/user",fallback = UserServiceFallback.class)
public interface UserService {
    
    @GetMapping
    String index();
    
    @GetMapping("/{id}")
    String index(@PathVariable String id);
}
