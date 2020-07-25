package com.shailahir.apps.textlocal.api;

import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.api.model.MessageSentResponse;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface TextlocalApi {
    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender) throws TextlocalException, UnsupportedEncodingException;

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity, boolean unicodeFlag, boolean trackingLinksFlag) throws TextlocalException, UnsupportedEncodingException;

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity, boolean unicodeFlag) throws UnsupportedEncodingException, TextlocalException;

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity) throws UnsupportedEncodingException, TextlocalException;

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag) throws UnsupportedEncodingException, TextlocalException;

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl, String custom) throws UnsupportedEncodingException, TextlocalException;

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime, String receiptUrl) throws UnsupportedEncodingException, TextlocalException;

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime) throws UnsupportedEncodingException, TextlocalException;

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity, boolean unicodeFlag, boolean trackingLinksFlag) throws TextlocalException, UnsupportedEncodingException;

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity, boolean unicodeFlag) throws TextlocalException, UnsupportedEncodingException;

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag, String validity) throws TextlocalException, UnsupportedEncodingException;

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl, String custom, boolean optoutsFlag) throws TextlocalException, UnsupportedEncodingException;

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl, String custom) throws TextlocalException, UnsupportedEncodingException;

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl) throws TextlocalException, UnsupportedEncodingException;

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime) throws TextlocalException, UnsupportedEncodingException;

    public MessageSentResponse sendMessage(String message, String groupId, String sender) throws TextlocalException, UnsupportedEncodingException;


}
