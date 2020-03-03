package com.cn.csx.broker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author csx
 * @Date 2020-03-02 21:33
 * @Description TODO
 */
public class BrokerServer implements  Runnable {

    public static int SERVICE_PORT=9999;

    private final Socket socket;

    public BrokerServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream())) {
           while (true){
               String str = in.readLine();
               if (str==null){
                   continue;
               }
               System.out.println("接受到的原始数据:"+str);
               if (str.equals("CSX")){
                   //从队列中获取CSX消费
                   String message = Broker.consume();
                   out.println(message);
                   out.flush();
               }else{
                   //其他的数据都方锐队列
                   Broker.produce(str);
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(SERVICE_PORT);
        while (true){
            BrokerServer brokerServer = new BrokerServer(server.accept());
            new Thread(brokerServer).start();
        }
    }

}
