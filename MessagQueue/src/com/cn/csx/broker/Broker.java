package com.cn.csx.broker;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author csx
 * @Date 2020-03-02 21:17
 * @Description TODO
 */
public class Broker {

    /**
     * ArrayBlockingQueue
     * 有界的阻塞队列文档来源
     * https://www.cnblogs.com/kexianting/p/8550598.html
     */

    /**
     * 队列存储消息最大数量
     */
    private final  static  int MAX_SIZE= 3;

    /**
     * 保存消息数据的容器
     * ArrayBlockingQueue解释
     * 数组实现的线程安全的有界的阻塞队列
     * 线程安全是指，ArrayBlockingQueue内部通过“互斥锁”保护竞争资源，实现了多线程对竞争资源的互斥访问。
     * 而有界，则是指ArrayBlockingQueue对应的数组是有界限的。
     * 阻塞队列，是指多线程访问竞争资源时，当竞争资源已被某线程获取时，其它要获取该资源的线程需要阻塞等待；
     * 而且，ArrayBlockingQueue是按 FIFO（先进先出）原则对元素进行排序，元素都是从尾部插入到队列，从头部开始返回。
     * 注意：ArrayBlockingQueue不同于ConcurrentLinkedQueue，ArrayBlockingQueue是数组实现的，并且是有界限的；而ConcurrentLinkedQueue是链表实现的，是无界限的。
     */
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);

    /**
     * 生产消息
     * @param msg
     */
    public static void produce(String msg){
        //offer 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则返回 false。
        if (messageQueue.offer(msg)){
            System.out.println("成功向消息处理中心投递消息:"+msg+",当前暂存的消息数量是:"+messageQueue.size());
        }else {
            System.out.println("消息处理中心内暂存的消息达到最大负荷,不能继续存入~");
        }
        System.out.println("=====================");
    }

    /**
     * 小消费消息
     * @return
     */
    public static String consume(){
        //poll 获取并移除此队列的头，如果此队列为空，则返回 null。
        String msg = messageQueue.poll();
        if (msg!=null) {
            //满足消费条件,取出一条消息
            System.out.println("已经消费消息:"+msg+",当前暂存消息数量为:"+messageQueue.size());
        }else {
            System.out.println("暂时没有消息可消费~");
        }
        System.out.println("====================");
        return  msg;
    }



}
