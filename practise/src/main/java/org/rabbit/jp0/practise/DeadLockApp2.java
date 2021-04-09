package org.rabbit.jp0.practise;

public class DeadLockApp2 {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();
    public static void main(String[] args) {
        new Thread( () -> {
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
        }).start();

        new Thread( () -> {
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
        }).start();
    }
}
