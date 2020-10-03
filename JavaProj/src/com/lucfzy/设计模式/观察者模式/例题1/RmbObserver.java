package com.lucfzy.设计模式.观察者模式.例题1;

// 人民币汇率波动的观察者接口对象
public interface RmbObserver {
    public void rateUP();
    public void rateDown();
}
