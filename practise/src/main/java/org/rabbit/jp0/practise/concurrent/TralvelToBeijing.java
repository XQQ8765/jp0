package org.rabbit.jp0.practise.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier强调的是n个线程，大家相互等待，只要有一个没完成，所有人都得等着.
 * https://blog.csdn.net/qq_37888382/article/details/101512560
 */
public class TralvelToBeijing {
    public static void main(String[] args) {
        String[] names = new String[] {
                "Rabbit", "Terry", "Eric", "Penny"
        };
        CyclicBarrier cyclicBarrier = new CyclicBarrier(names.length, new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " finish the last step.");
            }
        });

        for (String name : names) {
            new Thread(new TralvelTask(name, cyclicBarrier), "Thread-"+ name).start();
        }
    }
}

class TralvelTask implements Runnable {
    private String people;
    private CyclicBarrier cyclicBarrier;

    public TralvelTask(String people, CyclicBarrier cyclicBarrier) {
        this.people = people;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            int spentTime = sleepARandTime();
            System.out.println(people + " arrive to GangZhou South railway station, spent " + spentTime + "ms.");
            cyclicBarrier.await();

            sleepARandTime();
            System.out.println(people + " taken to the train, spent " + spentTime + "ms.");
            cyclicBarrier.await();

            sleepARandTime();
            System.out.println(people + " arrives to beijing, spent " + spentTime + "ms.");
            cyclicBarrier.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private int sleepARandTime() {
        int randomTime = new Random().nextInt(1000);
        try {
            Thread.sleep(randomTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return randomTime;
    }
}
