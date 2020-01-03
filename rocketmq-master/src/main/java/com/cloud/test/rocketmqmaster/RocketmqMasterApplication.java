package com.cloud.test.rocketmqmaster;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;


@SpringCloudApplication
public class RocketmqMasterApplication {
    
    public static void main(String[] args){
        SpringApplication.run(RocketmqMasterApplication.class,args);
    }
}
