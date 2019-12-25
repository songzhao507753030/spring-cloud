package com.cloud.test.configmaster.register;


import com.cloud.test.configmaster.filter.CoreConfigFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

/**
 * Date : 2019/12/25
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@Configuration
public class ConfigRegister implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean<CoreConfigFilter> index(){
        var filter = new FilterRegistrationBean<CoreConfigFilter>();
        filter.setUrlPatterns(Collections.singleton("/*"));
        filter.setFilter(new CoreConfigFilter());
        filter.setOrder(1);
        filter.setAsyncSupported(true);
        return filter;
    }
}
