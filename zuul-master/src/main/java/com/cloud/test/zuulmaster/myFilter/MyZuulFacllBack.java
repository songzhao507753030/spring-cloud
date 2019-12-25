package com.cloud.test.zuulmaster.myFilter;


import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Date : 2019/12/23
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :   失败会调用该方法
 */
@Component
public class MyZuulFacllBack implements FallbackProvider {
    
    @Override
    public String getRoute(){
        return "feign-master";
    }
    
    // 参数代表异常原因
    @Override
    public ClientHttpResponse fallbackResponse(String route,Throwable cause){
        
        return new ClientHttpResponse() {
            
            // 响应码  正常或异常等判断
            @Override
            public HttpStatus getStatusCode() throws IOException{
                return HttpStatus.BAD_REQUEST;
            }
    
            // 响应码值
            @Override
            public int getRawStatusCode() throws IOException{
                return HttpStatus.BAD_REQUEST.value();
            }
    
            // 响应描述
            @Override
            public String getStatusText() throws IOException{
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }
    
            @Override
            public void close(){
        
            }
    
            @Override
            public InputStream getBody() throws IOException{
                return new ByteArrayInputStream(("出现错误"+getRoute()).getBytes());
            }
    
            @Override
            public HttpHeaders getHeaders(){
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
