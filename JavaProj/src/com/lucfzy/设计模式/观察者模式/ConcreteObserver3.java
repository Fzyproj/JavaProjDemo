package com.lucfzy.设计模式.观察者模式;

public class ConcreteObserver3 implements Observer{
    @Override
    public void response(String event) {
        System.out.println(event);
        System.out.println("观察者3更新了状态、、、");
    }
}