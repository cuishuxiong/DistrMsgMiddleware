package com.cn.csx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author csx
 * @Date 2020-05-31 11:10
 * @Description 消息生产者
 */
public class Producer {

  public static void main(String[] args) throws IOException, TimeoutException {
    //创建连接工厂
      ConnectionFactory factory = new ConnectionFactory();
      factory.setUsername("admin");
      factory.setPassword("admin");
      //设置MQ地址
      factory.setHost("182.92.160.97");
      factory.setVirtualHost("/");
      //创建到代理服务器的连接
      Connection connection = factory.newConnection();
      //创建信道
      Channel channel = connection.createChannel();
      //声明交换器
      String exchangeName = "hello";
      channel.exchangeDeclare(exchangeName,"direct",true);

      String routingKey = "testRK";
      //发布消息
      byte[] msg = "查看mq日志".getBytes();
      channel.basicPublish(exchangeName,routingKey,null,msg);
      //关闭信道和连接
      channel.close();
      connection.close();
  }
}
