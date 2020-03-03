package com.cn.csx.consumer;

import com.cn.csx.broker.BrokerServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author csx
 * @Date 2020-03-02 21:44
 * @Description TODO
 */
public class MqClient {

    /**
     * 生产消息
     * @param msg
     * @throws IOException
     */
    public static  void  produce(String msg) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try(PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            out.println(msg);
            out.flush();
        }
    }

    /**
     * 消费消息
     * @return
     * @throws IOException
     */
    public static  String consume() throws IOException{
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            //先消费CSX
            out.println("CSX");
            out.flush();
            String msg = in.readLine();
            return  msg;
        }
    }


}
