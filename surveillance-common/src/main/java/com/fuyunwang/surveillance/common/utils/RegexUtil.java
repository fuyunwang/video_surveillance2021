package com.fuyunwang.surveillance.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: FuyunWang
 * @time: 2020/7/19 14:18
 */
public class RegexUtil {

    public static boolean match(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
