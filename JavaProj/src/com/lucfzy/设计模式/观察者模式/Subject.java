package com.lucfzy.设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<Observer> observerList = new ArrayList<>();

    /**
     * 增加观察者信息
     * @param ob
     */
    public void add(Observer ob) {
        observerList.add(ob);
    }
    /**
     * 移除观察者信息
     */
    public void remove(Observer ob){
        observerList.remove(ob);
    }
}
