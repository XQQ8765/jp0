package org.rabbit.jp0.practise.producer.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *  Java生产者消费者流程图_Java 生产者消费者模型的三种实现过程
 *  原文链接：https://blog.csdn.net/weixin_33404792/article/details/114560886
 *  3.使用BlockingQueue
 * 阻塞队列本身就是当队满的时候阻塞线程，故直接使用就可以实现生产者/消费者模型。
 * 阻塞队列内部也是使用ReenterantLock实现的。
 */
public class ProducerCustomerModelUsingBlockedQueue {
    static int MAX_SIZE = 10;
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(MAX_SIZE);

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Customer()).start();
    }

    private static class Producer implements Runnable{
        public void run() {
            while(true){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    queue.put(1);
                    System.out.println("生产了一个产品，现在有"+queue.size()+"个产品。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    private static class Customer implements Runnable{
        public void run() {
            while(true){
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    queue.take();
                    System.out.println("消费了一个产品，现在有"+queue.size()+"个产品。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
