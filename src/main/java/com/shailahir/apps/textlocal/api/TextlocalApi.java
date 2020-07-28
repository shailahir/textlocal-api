package com.shailahir.apps.textlocal.api;

import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.api.model.MessageSentResponse;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface TextlocalApi {
    MessageSentResponse sendMessage(String message, List<String> numbers, String sender) throws TextlocalException, UnsupportedEncodingException;

    MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity, boolean unicodeFlag, boolean trackingLinksFlag) throws TextlocalException, UnsupportedEncodingException;

    MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity, boolean unicodeFlag) throws UnsupportedEncodingException, TextlocalException;

    MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity) throws UnsupportedEncodingException, TextlocalException;

    MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag) throws UnsupportedEncodingException, TextlocalException;

    MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl, String custom) throws UnsupportedEncodingException, TextlocalException;

    MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl) throws UnsupportedEncodingException, TextlocalException;

    MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime) throws UnsupportedEncodingException, TextlocalException;

    MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity, boolean unicodeFlag, boolean trackingLinksFlag) throws TextlocalException, UnsupportedEncodingException;

    MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity, boolean unicodeFlag) throws TextlocalException, UnsupportedEncodingException;

    MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity) throws TextlocalException, UnsupportedEncodingException;

    MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag) throws TextlocalException, UnsupportedEncodingException;

    MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl, String custom) throws TextlocalException, UnsupportedEncodingException;

    MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl) throws TextlocalException, UnsupportedEncodingException;

    MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime) throws TextlocalException, UnsupportedEncodingException;

    MessageSentResponse sendMessage(String message, String groupId, String sender) throws TextlocalException, UnsupportedEncodingException;



}
