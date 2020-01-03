package com.cloud.test.rocketmqmaster.message;


import com.alibaba.fastjson.JSONObject;
import com.cloud.test.rocketmqmaster.AccountChangeEvent;
import com.cloud.test.rocketmqmaster.mapper.UserMapper;
import com.cloud.test.rocketmqmaster.service.UserService;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Date : 2020/1/3
 * Tool :  Intellij IDEA
 * Author : Song
 * Mail : herogmaiI@gmail.com
 * Describe :  监听事务发送消息是否被mq接受成功的状态
 */
@Component
@RocketMQTransactionListener(txProducerGroup = "producer_group_txmsg_bank1")
public class ProducerTxmsgListener implements RocketMQLocalTransactionListener {
    
    @Autowired
    UserService userService;
    
    
    @Autowired
    UserMapper userMapper;
    
    // 事务消息发送后的回调方法 ，当消息发给mq成功后此方法会被回调。
    @Override
    @Transactional
    public RocketMQLocalTransactionState executeLocalTransaction(Message message,Object o){
    
        try {
            // 解析message，然后转成AccountChangeEvent对象
            var payload = message.getPayload();
            var messageString = new String((byte[])payload);
            var jsonObject = JSONObject.parseObject(messageString);
            var accountChange = jsonObject.getString("accountChange");
            // json格式字符串转对象
            var accountChangeEvent = JSONObject.parseObject(accountChange,AccountChangeEvent.class);
            //指定本地事务扣减金额。
            userService.doUpdateAccountBalance(accountChangeEvent);
            return RocketMQLocalTransactionState.COMMIT;
        } catch(Exception e) {
            e.printStackTrace();
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }
    
    
    // 事务状态回查，查询是否扣减金额
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message){
        userMapper.isExistTx();
        return null;
    }
}
