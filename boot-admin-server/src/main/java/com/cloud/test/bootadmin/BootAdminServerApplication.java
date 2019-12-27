package com.cloud.test.bootadmin;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient   //开启一个eureka客户端
@EnableAdminServer   //开启一个监控服务
@SpringBootApplication
public class BootAdminServerApplication {
    public static void main(String[] args){
        SpringApplication.run(BootAdminServerApplication.class,args);
    }
}
