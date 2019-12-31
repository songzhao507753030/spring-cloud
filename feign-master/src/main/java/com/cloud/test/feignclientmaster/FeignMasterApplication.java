package com.cloud.test.feignclientmaster;


import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.ReactiveHystrixCircuitBreakerFactory;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableHystrixDashboard
@SpringCloudApplication
public class FeignMasterApplication {
    
    public static void main(String[] args){
        SpringApplication.run(FeignMasterApplication.class,args);
    }
    
    
    // @Bean
    // public Customizer<ReactiveHystrixCircuitBreakerFactory> defaultConfig() {
    //     return factory -> factory.configureDefault(id -> HystrixObservableCommand.Setter
    //                                                              .withGroupKey(HystrixCommandGroupKey.Factory.asKey(id))
    //                                                              .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
    //                                                                                                                                .withExecutionTimeoutInMilliseconds(4000)));
    // }
    
    
    
    // @Bean
    // public Customizer<ReactiveHystrixCircuitBreakerFactory> customizer() {
    //     return factory -> factory.configure(builder -> builder.commandProperties(
    //             HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(2000)), "foo", "bar");
    // }
}
