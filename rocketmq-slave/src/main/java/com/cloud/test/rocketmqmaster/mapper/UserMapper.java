package com.cloud.test.rocketmqmaster.mapper;


import org.apache.ibatis.annotations.*;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 */
@Mapper
public interface UserMapper {
    
    
    @Update("update account_info set account_balance=account_balance+#{amount} where account_no=#{accountNo}")
    int updateAccountBalance(@Param("accountNo") String accountNo,@Param("amount") Double amount);
    
    @Select("select count(1) from de_duplication where tx_no = #{txNo}")
    int isExistTx(String txNo);
    
    @Insert("insert into de_duplication values(#{txNo},now());")
    int addTx(String txNo);
    
    
}
