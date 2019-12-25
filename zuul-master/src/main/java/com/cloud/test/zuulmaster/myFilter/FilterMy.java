package com.cloud.test.zuulmaster.myFilter;


import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * Date : 2019/12/23
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :     zuul 过滤器
 */
public class FilterMy extends ZuulFilter {

    // 执行之前或后
    @Override
    public String filterType(){
        return FilterConstants.PRE_TYPE;
    }


    // 优先级  数字越小优先级越高
    @Override
    public int filterOrder(){
        return 0;
    }


    // 是否执行过滤
    @Override
    public boolean shouldFilter(){
        return true;
    }


    // 过滤规则
    @Override
    public Object run() {
        return null;
    }
}
