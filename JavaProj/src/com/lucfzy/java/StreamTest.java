package com.lucfzy.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        ChannelInfo channelInfo = new ChannelInfo("123456", "abcderf");
        ChannelInfo channelInfo1 = new ChannelInfo("123456", "abcderf");
        ChannelInfo channelInfo2 = new ChannelInfo("1234567", "abcderf");
        ChannelInfo channelInfo3 = new ChannelInfo("1234568", "abcderf");
        List<ChannelInfo> channelList = new ArrayList<>();
        channelList.add(channelInfo);
        channelList.add(channelInfo1);
        channelList.add(channelInfo2);
        channelList.add(channelInfo3);

        List<String> collect = channelList.stream()
                .map(ChannelInfo::getChannelId)
                .distinct()
                .collect(Collectors.toList());
        Set<String> setCollector = channelList.stream()
                .map(ChannelInfo::getChannelId)
                .collect(Collectors.toSet());

        for (String s : collect) {
            System.out.println(s);
        }

        for (String s : setCollector) {
            System.out.println(s);
        }

    }
}
