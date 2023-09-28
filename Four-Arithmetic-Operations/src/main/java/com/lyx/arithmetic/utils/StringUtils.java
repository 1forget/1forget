package com.lyx.arithmetic.utils;

import java.util.regex.Pattern;

/**
 * Description:
 *
 * @author lyx
 * Date:2023/9/27 23:07
 */
public class StringUtils {
    public static boolean isPositiveInteger(String str) {
        // 使用正则表达式检查是否为正整数
        return Pattern.matches("\\d+", str);
    }

}
