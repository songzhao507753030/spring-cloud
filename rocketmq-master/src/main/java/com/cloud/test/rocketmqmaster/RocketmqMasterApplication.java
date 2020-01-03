package com.cloud.test.rocketmqmaster;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableHystrixDashboard
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
public class RocketmqMasterApplication {
    
    public static void main(String[] args){
        SpringApplication.run(RocketmqMasterApplication.class,args);
    }
    
}
