package org.rabbit.jp0.practise.point;

/*
判断点和圆的关系(在圆外、在圆周上、在圆内)
思路：比较半径和两点之间的距离
https://blog.csdn.net/ams90203/article/details/101984847
*/

//点对象
class Point {
    private int x;//横坐标
    private int y;//纵坐标

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


//圆对象
class Circle {
    private int r;//半径

    Circle(int r) {
        this.r = r;
    }

    /*
    判断点和圆的关系
    参数：  需要判断的点对象
    返回：
    1：表明在圆外
    0：表明在圆周上
     -1：表明在圆内
    */
    int judge(Point p) {
        //x的平方和加上y的平方和
        int xxyy = p.getX() * p.getX() + p.getY() * p.getY();
        int rr = this.r * this.r;
        if (xxyy > rr) {
            return 1;
        } else if (xxyy < rr) {
            return -1;
        } else
            return 0;
    }
}


//判断一个点和圆的关系
class PointDemo {
    public static void main(String[] args) {
//创建一个点对象
        Point p = new Point(3, 4);
//创建一个半径为5的圆对象
        Circle c = new Circle(5);
//判断
        int ret = c.judge(p);
        System.out.println(ret);//输出位0，表示在圆上

    }
}
