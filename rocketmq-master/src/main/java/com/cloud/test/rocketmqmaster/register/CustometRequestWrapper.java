package com.cloud.test.rocketmqmaster.register;


import org.springframework.stereotype.Component;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Date : 2019/12/25
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@Component
public class CustometRequestWrapper extends HttpServletRequestWrapper {

    public CustometRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    
    @Override
    public ServletInputStream getInputStream() {
        var bytes = new byte[0];
        var byteArrayInputStream = new ByteArrayInputStream(bytes);


        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return byteArrayInputStream.read() == -1 ? true:false;
            }
            @Override
            public boolean isReady() {
                return false;
            }
            @Override
            public void setReadListener(ReadListener readListener) {

            }
            @Override
            public int read() {
                return byteArrayInputStream.read();
            }
        };
    }
}