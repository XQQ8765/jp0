package org.rabbit.jp0.practise.string.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些字符串相关面试题的java实现
 * 1.字符串右移n位
 * 2.字符串反转
 * 3.返回任意整数对应二进制形式中的1的个数
 * 4.显示字符串中字符的所有排序
 * http://m.myexceptions.net/program/838469.html
 */
public class StringTool {
    public static void main(String[] args){
        System.out.println(strMoveLeft("alhgon1o4n34lln1231",10));
        System.out.println(strReverse("alhgon1o4n34lln1231b"));
        System.out.println(oneStat(15));
        sort("abcj");
    }

    //字符串右移n位
    private static String strMoveLeft(String a,int moveNum){
        char[] a1 = a.toCharArray();
        char[] b1 = new char[a1.length];
        moveNum %= a.length();	//移动位数可能大于数组长度

        for(int i=0;i<a1.length;i++){
            if(i-moveNum>=0){
                b1[i-moveNum] = a1[i];
            }else{
                b1[i-moveNum+a1.length] = a1[i];
            }
        }
        return String.valueOf(b1);
    }
    //字符串反转
    private static String strReverse(String a){
        char[] a1 = a.toCharArray();

        for(int i=0;i<a1.length/2;i++){
            char temp = a1[i];
            a1[i] = a1[a1.length-i-1];
            a1[a1.length-i-1] = temp;
        }
        return String.valueOf(a1);
    }
    //返回任意整数对应二进制形式中的1的个数
    private static int oneStat(int i){
        int b = 0;
        while(i>0){
            if(i%2==1){
                b+=1;
            }
            i/=2;
        }
        return b;
    }
    //显示字符串中字符的所有排序，没有去重
    private static void sort(String a){
        char[] a1 = a.toCharArray();
        List<Character> list = new ArrayList<Character>();
        for(int i=0;i<a1.length;i++){
            list.add(a1[i]);
        }
        StringBuffer sb = new StringBuffer();
        display(list, sb);
    }

    private static void display(List<Character> list,StringBuffer sb){
        if(list.size()==0){
            System.out.println(sb.toString());
            return;
        }
        for(int i=0;i<list.size();i++){
            List<Character> dealList = new ArrayList<Character>(list);
            StringBuffer dealSb = new StringBuffer(sb);

            dealSb.append(String.valueOf(list.get(i)));
            dealList.remove(i);

            display(dealList,dealSb);//递归实现
        }
    }
}
