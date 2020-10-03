package com.lucfzy.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) throws Exception {
        // 利用反射调用方法
        // 获取类
        Class<?> appleClass = Class.forName("com.lucfzy.fanshe.Apple");
        // 获取构造器
        Constructor<?> appleClassConstructor = appleClass.getConstructor();
        // 获取对象
        Object appleObj = appleClassConstructor.newInstance();
        // 获取set方法
        Method setPriceMethod = appleClass.getMethod("setPrice", int.class);
        // 调用set方法
        setPriceMethod.invoke(appleObj, 10);
        // 获取get方法
        Method getPriceMethod = appleClass.getMethod("getPrice");
        // 直接获取对象属性
        Field price = appleClass.getDeclaredField("price");
        price.setAccessible(true);
        price.set(appleObj,20);
        // 调用get方法
        System.out.println(getPriceMethod.invoke(appleObj));

        Method printNameMethod = appleClass.getDeclaredMethod("printName");
        printNameMethod.setAccessible(true);
        printNameMethod.invoke(appleObj);

        Map<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"fuzeyi");
        hashMap.put(1,"luye");
        hashMap.forEach((key, value) -> System.out.println(key));
    }
}
