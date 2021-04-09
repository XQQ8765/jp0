package org.rabbit.jp0.practise.producer;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 线程A向队列Q中不停写入数据，线程B从队列Q中不停读取数据
 * https://blog.csdn.net/qauchangqingwei/article/details/82151271
 */
public class MyProgram1 {
    private static final int MAX_SIZE = 10;
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(MAX_SIZE);

    private static final Runnable producerTask = new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    int i = new Random().nextInt(10);
                    queue.put(i);
                    System.out.println("Put:" + i + ", queue.size():" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static final Runnable consumerTask = new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(400L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    int j = queue.take();
                    System.out.println("Consumer:" + j + ", queue.size():" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public static void main(String[] args) {
        new Thread(producerTask).start();;
        new Thread(consumerTask).start();;
    }
}
