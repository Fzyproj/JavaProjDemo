package com.lucfzy.fanshe;

public class Apple {
    private int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    private void printName() {
        System.out.println(this.price);
    }
}
