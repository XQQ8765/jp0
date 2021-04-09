package org.rabbit.jp0.practise;

/**
 * A Deadlock app
 */
public class DeadLockApp {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();
    public static void main(String[] args) {
        new Thread(new TaskAB()).start();
        new Thread(new TaskBA()).start();
    }

    static class TaskAB implements Runnable {
        public void run() {
            synchronized (lockA) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.print("TaskAB complete.");
                }
            }
        }
    }

    static class TaskBA implements Runnable {
        public void run() {
            synchronized (lockB) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA) {
                    System.out.print("TaskBA complete.");
                }
            }
        }
    }
}
