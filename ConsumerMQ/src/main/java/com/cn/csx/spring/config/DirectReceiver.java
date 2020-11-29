package com.cn.csx.spring.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/** @Author csx @Date 2020-10-07 10:37 @Description TODO */
@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {

  @RabbitHandler
  public void process(Map msg) {
    System.out.println("接受到的消息是:"+msg.toString());
  }
}
