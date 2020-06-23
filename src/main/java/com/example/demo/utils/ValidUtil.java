package com.example.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class ValidUtil {
    public static void validByRegex(String name, String value, boolean allowNull, String regex) {
        if (!StringUtils.hasText(value)) {
            Assert.isTrue(allowNull, String.format("[%s]不能为空", name));
        } else {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);
            Assert.isTrue(matcher.matches(), String.format("[%s]不合法", name));
        }
    }
}
