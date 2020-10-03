package com.lucfzy;

import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args)  {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(MyClass.j);
        System.out.println(myClass2.i);
        System.out.println(MyClass.j);
        MyClass.j = 1;
        System.out.println(myClass2.j);
        System.out.println(MyClass2.j);
        System.out.println(new MyClass2().i);
        System.out.println(new MyClass2().i);
        System.out.println(new MyClass2().i);

        List objects = Collections.EMPTY_LIST;

    }
}

class MyClass {
    public final double i = Math.random();
    // 在方法区中保存
    public static double j = Math.random();
}

class MyClass2 {
    // 在堆中分配，吗，每个类中不唯一。
    public final double i = Math.random();
    // 在方法区中分配，每个类中唯一。除非重新赋值
    public static double j = Math.random();
}