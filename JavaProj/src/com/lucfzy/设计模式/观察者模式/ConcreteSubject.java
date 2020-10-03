package com.lucfzy.设计模式.观察者模式;

import java.util.function.Consumer;

public class ConcreteSubject extends Subject{
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");
        int i =  0;
        super.observerList.forEach(observer -> observer.response(String.valueOf(i)));
    }
}
