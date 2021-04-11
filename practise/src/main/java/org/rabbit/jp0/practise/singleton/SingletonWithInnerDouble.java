package org.rabbit.jp0.practise.singleton;

/**
 * http://www.blogjava.net/kenzhh/archive/2013/03/15/357824.html Java：单例模式的七种写法
 * 第七种（双重校验锁）
 */
public class SingletonWithInnerDouble {
    private static SingletonWithInnerDouble INSTANCE;
    private SingletonWithInnerDouble() {
    }

    public static SingletonWithInnerDouble getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonWithInnerDouble.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonWithInnerDouble();
                }
            }
        }
        return INSTANCE;
    }
}
