package com.cloud.test.zuulmaster;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulMasterApplication {

    public static void main(String[] args){
        SpringApplication.run(ZuulMasterApplication.class,args);
    }
}
