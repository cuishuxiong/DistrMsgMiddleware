package com.cn.csx;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author csx
 * @Date 2020-05-31 11:10
 * @Description 消息消费者
 */
public class Consumer {

  public static void main(String[] args) throws IOException, TimeoutException {
    //
      ConnectionFactory factory = new ConnectionFactory();
      factory.setUsername("admin");
      factory.setPassword("admin");
      factory.setHost("182.92.160.97");
      factory.setVirtualHost("/");
      Connection connection = factory.newConnection();
      //创建信道
      final Channel channel = connection.createChannel();
      //声明交换器
      String exchangeName = "hello";
      channel.exchangeDeclare(exchangeName,"direct",true);
      //声明队列
      String queueName = channel.queueDeclare().getQueue();
      String routingKey = "testRK";
      //绑定队列,通过路由RK将队列与交换器绑定
      channel.queueBind(queueName,exchangeName,routingKey);
      while (true){
          //消费消息
          boolean autoAck = false;
          String consumertag = "";
          channel.basicConsume(queueName,autoAck,consumertag,new DefaultConsumer(channel){
              @Override
              public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                  String rk = envelope.getRoutingKey();
                  String contentType = properties.getContentType();
                  System.out.println("消费的路由键:"+rk);
                  System.out.println("消费的内容类型:"+contentType);
                  long dTag = envelope.getDeliveryTag();
                  //确认消息
                  channel.basicAck(dTag,false);
                  System.out.println("消费的内容:");
                  String bodyer = new String(body,"UTF-8");
                  System.out.println(bodyer);
              }
          });
      }

  }
}
