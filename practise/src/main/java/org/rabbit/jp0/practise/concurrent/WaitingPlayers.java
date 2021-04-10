package org.rabbit.jp0.practise.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Usage example for CountDownLatch.
 * CountDownLatch减计数. 一个非常典型的应用场景是：有一个任务想要往下执行，但必须要等到其他的任务执行完毕后才可以继续往下执行。
 * 用法：用给定的计数初始化CountDownLath。调用countDown()方法计数减 1，在计数被减到 0之前，调用await方法会一直阻塞。减为 0之后，则会迅速释放所有阻塞等待的线程，并且调用await操作会立即返回。
 * ps：CountDownLath计数无法被重置，如果需要重置计数，请考虑使用CyclicBarrier.
 *
 * See: https://blog.csdn.net/qq_37888382/article/details/101512560
 */
public class WaitingPlayers {
    private static final int TOTAL_PLAYERS = 4;
    private static CountDownLatch countDownLatch = new CountDownLatch(TOTAL_PLAYERS);

    public static void main(String[] args) {
        System.out.println("Waiting the players to come.");
        for (int i=0; i<TOTAL_PLAYERS; i++) {
            new PlayerThread(i, countDownLatch).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All the players has come, the game will start.");
    }
}

class PlayerThread extends Thread {
    private int id;
    private CountDownLatch countDownLatch;

    public PlayerThread(int id, CountDownLatch countDownLatch) {
        super("Thread-player-" + id);
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Player " + id + " comes to here.");
        countDownLatch.countDown();
    }
}
