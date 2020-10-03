package com.lucfzy.tomap;

import java.util.List;

public class User {
    private String name;
    private List<String> wifes;

    public User() {
    }

    public User(String name, List<String> wifes) {
        this.name = name;
        this.wifes = wifes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWifes() {
        return wifes;
    }

    public void setWifes(List<String> wifes) {
        this.wifes = wifes;
    }
}
