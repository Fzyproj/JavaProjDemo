package com.lucfzy.设计模式.观察者模式.例题1;

import java.util.function.Consumer;

// 具体的rmb汇率对象
public class ConcreteRmbRate extends RmbRate{
    public void rateUP() {
        // 通知rmbObserver进行响应的操作。
        super.rmbObserverList.forEach(RmbObserver::rateUP);
    }
    public void rateDown() {
        // 通知rmbObserver进行响应的操作。
        super.rmbObserverList.forEach(RmbObserver::rateDown);
    }
}
