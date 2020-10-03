package com.lucfzy.设计模式.观察者模式.例题1;

import java.util.ArrayList;
import java.util.List;

// 代表人民币的汇率
public abstract class RmbRate {

    List<RmbObserver> rmbObserverList = new ArrayList<>();

    public void add(RmbObserver ob) {
        rmbObserverList.add(ob);
    }

    public void remove(RmbObserver ob) {
        rmbObserverList.remove(ob);
    }

    public abstract void rateUP();

    public abstract void rateDown();
}
