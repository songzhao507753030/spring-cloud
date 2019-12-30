package com.cloud.test.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//@ServletComponentScan
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args){
        SpringApplication.run(GatewayApplication.class,args);
    }
    
    
    @Bean
    public KeyResolver uriKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange){
                // 获取用户的访问地址进而限流。
                System.out.println(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
                return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
            }
        };
    }
    
    // @Bean
    // public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    //
    //
    //     return builder.routes()
    //                   .route("path_route", r -> r.path("/get")
    //                                              .uri("http://httpbin.org"))
    //                   .route("host_route", r -> r.host("*.myhost.org")
    //                                              .uri("http://httpbin.org"))
    //                   .route("rewrite_route", r -> r.host("*.rewrite.org")
    //                                                 .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
    //                                                 .uri("http://httpbin.org"))
    //                   .route("hystrix_route", r -> r.host("*.hystrix.org")
    //                                                 .filters(f -> f.hystrix(c -> c.setName("slowcmd")))
    //                                                 .uri("http://httpbin.org"))
    //                   .route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
    //                                                          .filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
    //                                                          .uri("http://httpbin.org"))
    //                   .route("limit_route", r -> r
    //                                                      .host("*.limited.org").and().path("/anything/**")
    //                                                      .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
    //                                                      .uri("http://httpbin.org"))
    //                   .build();
    // }
}
