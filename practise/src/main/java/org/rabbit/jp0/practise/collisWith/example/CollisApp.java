package org.rabbit.jp0.practise.collisWith.example;

/**
 * 4.编写代码实现同一平面内两圆是否碰撞，其中：
 *
 * 第一个圆圆心坐标为(x1,y1)，半径是r1，第二个圆圆心坐标为(x2,y2)，半径是r2。
 * https://blog.csdn.net/qauchangqingwei/article/details/82151271
 */
public class CollisApp {
    boolean collisWith(int x1, int y1, int r1, int x2, int y2, int r2) {
        boolean flag=false;

        int num1=(x1-x2)*(x1-x2);

        int num2=(y1-y2)*(y1-y2);

        int num3=num1+num2;

        double distance=Math.sqrt(num3);

        if(distance<=(r1+r2)){
            flag=true;

        }

        return flag;

    }
}
