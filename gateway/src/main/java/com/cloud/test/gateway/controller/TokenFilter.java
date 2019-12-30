package com.cloud.test.gateway.controller;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Date : 2019/12/30
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :  自定义过滤器
 */
public class TokenFilter implements GlobalFilter, Ordered {
    
    /**
     *  自定义拦截器。
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain){
        var token = exchange.getRequest().getQueryParams().getFirst("token");
        if(token == null || token.isEmpty()){
            exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            System.out.println("token is null！");
            return exchange.getResponse().setComplete();
        }
        System.out.println("---- 过滤链 -----");
        return chain.filter(exchange);
    }
    
    // 返回不同数字,数字越小越先拦截。
    @Override
    public int getOrder(){
        return -1;
    }
}
