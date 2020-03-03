package com.cn.csx.consumer;

import java.io.IOException;

/**
 * @Author csx
 * @Date 2020-03-02 21:53
 * @Description TODO
 */
public class ConsumerClient {

    public static void main(String[] args) throws IOException {
       String msg =   MqClient.consume();
        System.out.println("获取的消息为:"+msg);
    }

}
