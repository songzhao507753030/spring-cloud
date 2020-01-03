package com.cloud.test.rocketmqmaster.filter;


import com.cloud.test.rocketmqmaster.register.CustometRequestWrapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date : 2019/12/25
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@Component
public class CoreConfigFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException{
        var httpServletRequest = (HttpServletRequest) request;
                var httpServletResponse = (HttpServletResponse) response;

                var url = new String(httpServletRequest.getRequestURI());
                System.out.println(url+"--------------------");

                //只过滤/actuator/bus-refresh请求
                if (!url.endsWith("/bus-refresh")) {
                    chain.doFilter(request,response);
                    return;
                }


                //使用HttpServletRequest包装原始请求达到修改post请求中body内容的目的
                var requestWrapper = new CustometRequestWrapper(httpServletRequest);

                chain.doFilter(requestWrapper,response);

    }

}
