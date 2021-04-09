package org.rabbit.jp0.practise.producer.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2.使用ReenterantLock
 * ReenterantLock与synchronized类似，synchronized在语句块结束后会自动释放锁，ReenterantLock需要unlock()。ReenterantLock还支持公平锁(等待最久的先拿锁)。
 * 需要设置两个条件，分别用于空/满时候的信号。
 * ————————————————
 * 原文链接：https://blog.csdn.net/weixin_33404792/article/details/114560886
 */
public class ProducerCustomerModelReentrantLock {
    static ReentrantLock lock = new ReentrantLock(true);
    static int MAX_SIZE = 10;
    static List<Integer> list;
    static Condition ableToProduce,ableToCustom;

    public static void main(String[] args) {
        list = new ArrayList<Integer>();

        ableToCustom = lock.newCondition();
        ableToProduce = lock.newCondition();

        new Thread(new Producer()).start();
        new Thread(new Customer()).start();
    }

    private static class Producer implements Runnable{
        public void run() {
            while(true) {
                try {
                    Thread.sleep(250);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

                lock.lock();

                while(list.size()>=MAX_SIZE) {
                    try {
                        ableToProduce.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }

                }

                list.add(1);

                System.out.println("生产了一个产品，现在有"+list.size()+"个产品。");

                ableToCustom.signal();

                lock.unlock();

            }

        }

    }

    private static class Customer implements Runnable{
        public void run() {
            while(true) {
                try {
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

                lock.lock();

                while(list.size()==0) {
                    try {
                        ableToCustom.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }

                }

                list.remove(0);

                System.out.println("消费了一个产品，现在有"+list.size()+"个产品。");

                ableToProduce.signal();

                lock.unlock();

            }

        }

    }

}
