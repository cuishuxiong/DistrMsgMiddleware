package com.cn.csx.producer;

import com.cn.csx.consumer.MqClient;

import java.io.IOException;

/**
 * @Author csx
 * @Date 2020-03-02 21:52
 * @Description TODO
 */
public class ProduceClient {

    public static void main(String[] args) throws IOException {
        MqClient.produce("初始化队列信息");
    }

}
