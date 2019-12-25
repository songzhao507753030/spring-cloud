package com.cloud.test.feignclientmaster;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringCloudApplication
public class FeignMasterApplication {
    
    public static void main(String[] args){
        SpringApplication.run(FeignMasterApplication.class,args);
    }
    
}
