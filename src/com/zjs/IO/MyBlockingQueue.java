package com.zjs.IO;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/7/28 16:50
 **/
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CyclicBarrier;

public class MyBlockingQueue {

    //队列
    private  final Queue<String> myQueue = new LinkedList<>();

    //最大长度
    private static final int MAXSIZE = 20;
    private static final int MINSIZE = 0;

    //获取队列长度
    public int getSize(){
        return myQueue.size();
    }

    //生产者
    public void push(String str) throws Exception {
        //拿到对象锁
        synchronized (myQueue){

            //如果队列满了，则阻塞
            if(getSize() == MAXSIZE){
                myQueue.wait();
            }

            myQueue.offer(str);
            System.out.println(Thread.currentThread().getName() + "放入元素" + str);
            //唤醒消费者线程，消费者和生产者自己去竞争锁
            myQueue.notify();
        }
    }

    //消费者
    public String pop() throws Exception {
        synchronized (myQueue){
            String result = null;

            //队列为空则阻塞
            if(getSize() == MINSIZE){
                myQueue.wait();
            }
            //先进先出
            result = myQueue.poll();

            System.out.println(Thread.currentThread().getName()+"取出了元素" + result);
            //唤醒生产者线程，消费者和生产者自己去竞争锁
            myQueue.notify();

            return result;
        }
    }

    public static void main(String args[]){

        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();

        //4个线程，都执行完成了打印
        CyclicBarrier barrier = new CyclicBarrier(4, ()->{
            System.out.println("生产结束，下班了，消费者明天再来吧！");
        });

        //生产者线程1
        new Thread(()->{
            //50个辛勤的生产者循环向队列中添加元素
            try {
                for(int i = 0; i < 50; i++){
                    myBlockingQueue.push("——" + i );
                }
                //生产完了
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"生产者1").start();

        //生产者线程2
        new Thread(()->{
            //50个辛勤的生产者循环向队列中添加元素
            try {
                for(int i = 50; i < 100; i++){
                    myBlockingQueue.push("——" + i );
                }
                //生产完了
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"生产者2").start();
        //消费者线程1
        new Thread(()->{
            //50个白拿的消费者疯狂向队列中获取元素
            try {
                for(int j = 0; j < 50; j++){
                    myBlockingQueue.pop();
                }
                //消费完了
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"消费者1").start();
        //消费者线程2
        new Thread(()->{
            //50个白拿的消费者疯狂向队列中获取元素
            try {
                for(int j = 0; j < 50; j++){
                    myBlockingQueue.pop();
                }
                //消费完了
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"消费者2").start();
    }
}