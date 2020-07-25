package com.shailahir.apps.textlocal.utils;

import java.util.List;

public class Utils {

    private static String removeCommaFromBufferEnd(StringBuffer buffer) {
        if (buffer.length() >= 1) {
            return buffer.substring(0, buffer.length() - 1);
        }
        return buffer.toString();
    }

    private static void addStringToBuffer(String number, StringBuffer buffer) {
        if (number != null && number.trim().length() != 0) {
            buffer.append(number);
            buffer.append(",");
        } else {
            throw new IllegalArgumentException("String length to be joined should not be empty");
        }
    }

    public static String joinStrings(List<String> numbers) {
        if (numbers != null && numbers.size() > 0) {
            StringBuffer buffer = new StringBuffer();
            for (String number : numbers) {
                addStringToBuffer(number, buffer);
            }
            return removeCommaFromBufferEnd(buffer);
        }
        return "";
    }
}
