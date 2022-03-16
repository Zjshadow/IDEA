package com.zjs.java;

/*
 * 定义一个测试类 InterfaceTest，创建两个 ComparableCircle 对象，
 * 调用 compareTo 方法比较两个类的半径大小。
 *
 */
public class InterfaceTest {
    public static void main(String[] args) {

        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.6);

        int compareValue = c1.compareTo(c2);
        if(compareValue > 0){
            System.out.println("c1 对象大");
        }else if(compareValue < 0){
            System.out.println("c2 对象大");
        }else{
            System.out.println("两个一样的");
        }

        int compareValue1 = c1.compareTo(new String("AA"));
        System.out.println(compareValue1);
    }
}


/*
 * 定义一个接口用来实现两个对象的比较。
 *
 */
interface CompareObject {
    public int compareTo(Object o);
    //若返回值是 0,代表相等;若为正数，代表当前对象大；负数代表当前对象小

}
/*
 * 定义一个 Circle 类，声明 redius 属性，提供 getter 和 setter 方法
 */

class Circle {

    private Double radius;

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Circle() {
        super();
    }

    public Circle(Double radius) {
        super();
        this.radius = radius;
    }

}

/*
 * 定义一个 ComparableCircle 类，继承 Circle 类并且实现 CompareObject 接口。在 ComparableCircle 类中给出接口中方法 compareTo 的实现体，
 * 用来比较两个圆的半径大小。
 */

class ComparableCircle extends Circle implements CompareObject{

    public ComparableCircle(double radius) {
        super(radius);
    }
    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }
        if(o instanceof ComparableCircle){
            ComparableCircle c = (ComparableCircle)o;
            //错误的写法
//			return (int)(this.getRedius() - c.getRedius());
            //正确的方式一：
//			if(this.getRadius() > c.getRadius()){
//				return 1;
//			}else if(this.getRadius() < c.getRadius()){
//				return -1;
//			}else{
//				return 0;
//			}
            //当属性 radius 声明为 Double 类型时，可以调用包装类的方法
            //正确的方式二：
            return this.getRadius().compareTo(c.getRadius());
        }else{
            return 0;
//			throw new RuntimeException("传入数据类型不匹配");
        }
    }
}

