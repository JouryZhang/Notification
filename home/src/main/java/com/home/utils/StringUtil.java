package com.home.utils;

import java.util.regex.Pattern;
/*判断非空的工具类*/
public class StringUtil {
    public static  boolean isNotEmpty(String b){
       if ("".equals(b)||null==b){
           return false;
       }else {
           return true;
       }
    }
    public static boolean isNullOrEmpty(Object b){
        if ("".equals(b)||null==b){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

}
