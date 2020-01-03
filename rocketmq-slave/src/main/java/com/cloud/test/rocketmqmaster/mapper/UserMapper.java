package com.cloud.test.rocketmqmaster.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<Map<String,Object>> selectUsers();

}
