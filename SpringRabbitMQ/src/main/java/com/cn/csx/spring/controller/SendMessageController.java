package com.cn.csx.spring.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author csx
 * @Date 2020-10-07 09:55
 * @Description TODO
 */
@RestController
public class SendMessageController {

    @Autowired
    RabbitTemplate template;

    @PostMapping("/sendDirectMessage")
    public String sendDirectMessage(@RequestBody Map<String,Object> params) {
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",params.get("msg"));
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        template.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "ok";
    }

    @PostMapping("/sendTopicMessage1")
    public String sendTopicMessage1(@RequestBody Map<String,Object> params) {
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", params.get("txt"));
        manMap.put("createTime", createTime);
        template.convertAndSend("topicExchange", "topic.man", manMap);
        return "ok";
    }

    @PostMapping("/sendTopicMessage2")
    public String sendTopicMessage2(@RequestBody Map<String,Object> params) {
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageId", messageId);
        womanMap.put("messageData", params.get("ctx"));
        womanMap.put("createTime", createTime);
        template.convertAndSend("topicExchange", "topic.woman", womanMap);
        return "ok";
    }



}
