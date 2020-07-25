package com.shailahir.apps.textlocal.api;

import com.shailahir.apps.textlocal.api.exception.TextlocalException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface TextlocalApi {
    public void sendMessage(String message, List<String> numbers, String sender) throws TextlocalException, UnsupportedEncodingException;
}
