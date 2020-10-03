package com.lucfzy.设计模式.观察者模式.例题1;

// 具体的rmb汇率观察者对象
public class ConcreteRmbObserver implements RmbObserver{

    @Override
    public void rateUP() {
        System.out.println("进口公司的进口产品成本降低且利润率提升，出口公司的出口产品收入降低且利润率降低；");
    }

    @Override
    public void rateDown() {
        System.out.println("进口公司的进口产品成本提升且利润率降低，出口公司的出口产品收入提升且利润率提升");
    }
}
