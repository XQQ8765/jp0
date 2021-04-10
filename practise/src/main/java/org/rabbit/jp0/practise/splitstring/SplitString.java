package org.rabbit.jp0.practise.splitstring;

import java.nio.charset.Charset;

/**
 * Unicode编码是指一类编码的统称, 因为java是以unicode作为编码方式的。unicode是一个定长的编码标准，每个字符都是2个字节，也就是1个char类型的空间。
 * 以utf8为例，utf8是一个变长编码标准，可以以1~4个字节表示一个字符，而中文占3个字节，ascII字符占1个字节。
 *
 * 题目：10、 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。 但是要保证汉字不被截半个，如“我ABC”4，应该截为“我AB”，
 * 输入“我ABC汉DEF”，6，应该输出为“我ABC”而不是“我ABC+汉的半个”。
 *
 * 一、需要分析
 * 1、输入为一个字符串和字节数，输出为按字节截取的字符串--------------》按照字节[byte]截取操作字符串，先将String转换成byte类型
 * 2、汉字不可以截半----》汉字截半的话对应字节的ASC码为小于0的数值
 *
 *
 * 二、技术难点
 * 1、知道汉字截半的话对应字节的ASC码为小于0的数值
 * 2、对字符串操作应该都要面对的一个问题，字符串是否有效null, 字符串的长度0,1这种边界处理
 *
 * https://www.cnblogs.com/zhaideyou/p/5929669.html
 * https://blog.csdn.net/qauchangqingwei/article/details/82151271
 */
public class SplitString {
    String SplitStr;
    int SplitByte;

    public SplitString(String str, int bytes) {
        SplitStr = str;
        SplitByte = bytes;
        System.out.println("The String is: " + SplitStr + ";SplitBytes= " + SplitByte);

    }

    public void splitIt2() {
        char[] chars = SplitStr.toCharArray();

        int charBytes = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            int chBytes = (""+ch).getBytes().length;
            if (charBytes + chBytes <= SplitByte) {
                charBytes += chBytes;
                sb.append(ch);
            }

            if (charBytes >= SplitByte) {
                System.out.println(sb.toString());
                sb = new StringBuilder();
                charBytes = 0;
            }
        }
    }

    public static void splitString(String src, int len) {
        int byteNum = 0;

        if (null == src) {
            System.out.println("The source String is null!");
            return;
        }

        byteNum = src.length();
        byte bt[] = src.getBytes(); // 将String转换成byte字节数组

        if (len > byteNum) {
            len = byteNum;
        }

        // 判断是否出现了截半，截半的话字节对于的ASC码是小于0的值
        if (bt[len] < 0) {
            String subStrx = new String(bt, 0, --len);
            System.out.println("subStrx==" + subStrx);
        } else {
            String subStrx = new String(bt, 0, len);
            System.out.println("subStrx==" + subStrx);
        }
    }

    public static void main(String[] args) {
        //String str = "test中dd文dsaf中男大3443n中国43中国人0ewldfls=103";
        Charset defaultCharSet = Charset.defaultCharset();//UTF-8
        Charset unicodeCharSet = Charset.forName("Unicode");//UTF-16
        int len0 = "我".getBytes().length;
        int lenUTF8 = "我".getBytes(Charset.defaultCharset()).length;
        int lenUnicode = "我".getBytes(unicodeCharSet).length;
        String str = "我ABC";
        SplitString ss = new SplitString(str, 4);
        ss.splitIt2();

        str = "我ABC汉DEF";
        ss = new SplitString(str, 6);
        ss.splitIt2();

        splitString(str, 6);
    }
}
