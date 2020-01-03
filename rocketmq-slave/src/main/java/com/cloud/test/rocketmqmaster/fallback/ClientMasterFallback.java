package com.cloud.test.rocketmqmaster.fallback;


import com.cloud.test.rocketmqmaster.service.ClientMaster;
import org.springframework.stereotype.Component;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 */
@Component
public class ClientMasterFallback implements ClientMaster {
    @Override
    public String index(){
        return "index Error";
    }
    
    @Override
    public String index(String id){
        return "index(String id) Error";
    }
}
