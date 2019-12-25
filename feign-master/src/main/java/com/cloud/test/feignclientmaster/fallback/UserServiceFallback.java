package com.cloud.test.feignclientmaster.fallback;


import com.cloud.test.feignclientmaster.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Date : 2019/12/19
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public String index(){
        return "index()  Exception";
    }
    
    @Override
    public String index(String id){
        return "index(String id)  Exception";
    }
}
