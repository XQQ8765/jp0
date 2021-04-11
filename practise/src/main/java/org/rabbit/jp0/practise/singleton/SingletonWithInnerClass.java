package org.rabbit.jp0.practise.singleton;

/**
 * http://www.blogjava.net/kenzhh/archive/2013/03/15/357824.html Java：单例模式的七种写法
 * 第五种（静态内部类）
 */
public final class SingletonWithInnerClass {
    private static class SingletonHolder {
        private final static SingletonWithInnerClass INSTANCE = new SingletonWithInnerClass();
    }

    private SingletonWithInnerClass() {

    }

    public static SingletonWithInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
