package com.lucfzy.guava;

import com.google.common.base.*;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class GuavaTemplate {
    private static final Cache<Integer, String> localCache = CacheBuilder.newBuilder()
            .concurrencyLevel(10)
            .initialCapacity(10)
            .maximumSize(100)
            .recordStats()
            .expireAfterWrite(60, TimeUnit.SECONDS)
            .build();
    public static void main(String[] args) {
        test_strings_tools();
        test_guava_cached_template();
    }

    public static void test_strings_tools() {
        Optional<Object> op1 = Optional.fromNullable(null); // 此时去get值会抛出异常
        Optional<String> op2 = Optional.fromNullable("string"); // get值： string。

        boolean b1 = Strings.isNullOrEmpty(""); // true
        boolean b2 = Strings.isNullOrEmpty(null); // true
        String s1 = Strings.nullToEmpty(null); // ""
        String s2 = Strings.emptyToNull(""); // null
        String commonPrefix1 = Strings.commonPrefix("aaa", "aabb"); // "aa"
        String commonPrefix2 = Strings.commonPrefix("aaa", "bb"); // ""
        String commonSuffix1 = Strings.commonSuffix("aaa", "ba"); // "a"
        String commonSuffix2 = Strings.commonPrefix("aaa", "bb"); // ""

        Object obj1 = Optional.fromNullable(null).or(new Object()); // 如果对象为空，那么使用默认值。

        Integer o = Preconditions.checkNotNull(1111); // o: 1111

        Iterable<String> split = Splitter.on(',').trimResults().omitEmptyStrings().split("foo,bar,,   qux"); // [foo, bar, qux]

    }

    private static void test_guava_cached_template() {
        localCache.put(1,"111");
        localCache.put(2,"222");
        localCache.put(3,"333");
        new Thread(() -> {
            String s = localCache.getIfPresent(1);
            System.out.println(s);
        }).start();
        new Thread(() -> {
            String ifPresent = localCache.getIfPresent(4);
            System.out.println(ifPresent);
        }).start();
    }
}
