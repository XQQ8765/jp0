package org.rabbit.jp0.gc;

public class TestPolicy2 {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+UseParNewGC -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728   (3M = 3145728 byte)
     *
     * -XX:PretenureSizeThreshold 用于控制大对象的阀值，如果对象大小大于此值，则直接进入老年代.　
     * 　　(此参数只在串行(Serial)和ParNewGC里使用才有效，对于其他GC无效。
     */

    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        //直接分配在老年代中
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
  }
}