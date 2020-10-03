package com.lucfzy.设计模式.观察者模式;

public class MainTest {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.add(new ConcreteObserver1());
        subject.add(new ConcreteObserver2());
        subject.add(new ConcreteObserver3());
        // 当变化式，调用notify方法去通知子类，去执行相应的方法来更新消费者状态。
        subject.notifyObserver();
    }
}
