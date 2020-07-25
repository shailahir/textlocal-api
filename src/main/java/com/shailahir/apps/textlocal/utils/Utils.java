package com.shailahir.apps.textlocal.utils;

public class Utils {
    public static String joinStrings(String[] arr) {
        if (arr != null && arr.length > 0) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null || arr[i].trim().length() != 0) {
                    buffer.append(arr[i]);
                    buffer.append(",");
                } else {
                    throw new IllegalArgumentException("String length to be joined should not be empty");
                }
            }
            if (buffer.length() >= 1) {
                return buffer.substring(0, buffer.length() - 1);
            }
            return buffer.toString();
        }
        return "";
    }
}
