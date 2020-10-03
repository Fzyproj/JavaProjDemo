package com.lucfzy.tomap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        User user1 = new User("fzy", Collections.singletonList("luye11"));
        User user2 = new User("fzy", Collections.singletonList("luye22"));
        User user3 = new User("fzy", Collections.singletonList("luye23"));
        User user4 = new User("fzy", Collections.singletonList("luye24"));
        User user5 = new User("fzy", Collections.singletonList("luye25"));
        User user6 = new User("fzy1", Collections.singletonList("luye25"));
        User user7 = new User("fzy", Collections.singletonList("luye26"));
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        Map<String, List<String>> collect = userList.stream().collect(Collectors.toMap(User::getName, User::getWifes, (strings, strings2) -> {
            List<String> list = new ArrayList<>();
            list.addAll(strings);
            list.addAll(strings2);
            return list;
        }));
        collect.forEach((s, strings) -> System.out.println(s+strings));
    }
}
