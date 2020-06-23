package com.example.demo.utils;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class TokenUtil {

    private static Cache<String, String> CACHE = CacheBuilder.newBuilder() //
            .maximumSize(100) // 
            .expireAfterAccess(1, TimeUnit.HOURS) // 
            .concurrencyLevel(10) // 设置并发级别为10
            .build();

    public static void put(String key, String value) {
        CACHE.put(key, value);
    }

    public static String get(String key) {
        return CACHE.getIfPresent(key);
    }

    public static void delete(String key) {
        CACHE.invalidate(key);
    }

}
