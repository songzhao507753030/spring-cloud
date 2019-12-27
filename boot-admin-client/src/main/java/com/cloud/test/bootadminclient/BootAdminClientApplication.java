package com.cloud.test.bootadminclient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BootAdminClientApplication {
    public static void main(String[] args){
        SpringApplication.run(BootAdminClientApplication.class,args);
    }
}
