package org.rabbit.jp0.practise.collisWith.example;

import java.util.Scanner;

/**
 * 2.编写代码判断同一平面内两圆的位置情况，
 * 其中：第一个圆圆心坐标为(x1,y1)，半径是r1，第二个圆圆心坐标为(x2,y2)，半径是r2。
 * https://blog.csdn.net/jsc123581/article/details/82026622
 */

public class JudgeLocation {
    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入第一个圆的x坐标：");
        int x1 = scan.nextInt();
        System.out.print("请输入第一个圆的y坐标：");
        int y1 = scan.nextInt();
        System.out.print("请输入第一个圆的半径r：");
        int r1 = scan.nextInt();
        System.out.print("请输入第二个圆的x坐标：");
        int x2 = scan.nextInt();
        System.out.print("请输入第二个圆的y坐标：");
        int y2 = scan.nextInt();
        System.out.print("请输入第二个圆的半径r：");
        int r2 = scan.nextInt();

        //判断两圆位置情况
        judgeLocation(x1,y1,r1,x2,y2,r2);

    }

    //判断两圆位置情况
    private static void judgeLocation (int x1, int y1, int r1, int x2, int y2, int r2) {

        //第一种方式
        //Math.pow(x,y)方法可返回 x的 y次幂的值,相当于（r1-r2）的平方，即最小圆心距的平方
        int rMin = (int) Math.pow(r1-r2,2);
        int rMax = (int) Math.pow(r1+r2,2);  //最大圆心距的平方
        int dis = (int)(Math.pow(x1-x2,2) + Math.pow(y1-y2, 2)); //两圆心距离的平方

        //第二种方式
        //int rmin = r1-r2;
        //int rmax = r1+r2;
        //int dis = (int) Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));

        if(rMin > dis && r2 < r1){
            System.out.println("第二个圆在第一个圆内!");
        }else if(rMin > dis && r1 < r2){
            System.out.println("第一个圆在第二个圆内!");
        }else if(rMin == dis){
            System.out.println("两圆内切!");
        }else if(dis > rMin && dis < rMax){
            System.out.println("两圆相交!");
        }else if(dis == rMax){
            System.out.println("两圆外切!");
        }else if(dis > rMax){
            System.out.println("两圆相离!");
        }

    }
}
