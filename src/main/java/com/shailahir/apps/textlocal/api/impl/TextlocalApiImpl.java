package com.shailahir.apps.textlocal.api.impl;

import com.shailahir.apps.textlocal.api.TextlocalApi;
import com.shailahir.apps.textlocal.api.constants.TextlocalConstants;
import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.api.model.MessageSentResponse;
import com.shailahir.apps.textlocal.api.model.ShortUrlResponse;
import com.shailahir.apps.textlocal.config.TextLocalConfig;
import com.shailahir.apps.textlocal.utils.JsonHelper;
import com.shailahir.apps.textlocal.utils.NetworkHelper;
import com.shailahir.apps.textlocal.utils.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class TextlocalApiImpl implements TextlocalApi {

    private final TextLocalConfig config;
    private final NetworkHelper networkHelper;

    public TextlocalApiImpl(TextLocalConfig config) throws TextlocalException {
        if (config == null || config.getApiKey() == null || config.getApiKey().trim().length() == 0) {
            throw new TextlocalException(TextlocalConstants.Errors.INVALID_CONFIG);
        }
        this.config = config;
        networkHelper = new NetworkHelper();
    }

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender)
            throws TextlocalException, UnsupportedEncodingException {
        return sendMessage(message, numbers, sender, null);
    }

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime,
                                           String receiptUrl, String custom, boolean optoutsFlag, String validity,
                                           boolean unicodeFlag, boolean trackingLinksFlag)
            throws TextlocalException, UnsupportedEncodingException {
        StringBuffer buffer = prepareApiCall(message, numbers, sender, scheduleTime, receiptUrl, custom, optoutsFlag,
                validity, unicodeFlag, trackingLinksFlag, null);
        String jsonResponse = sendToApi(config.getSendMessageUrl(), buffer.toString());
        return JsonHelper.extractMessageSentResponse(jsonResponse);
    }

    private StringBuffer prepareApiCall(String message, List<String> numbers, String sender, String scheduleTime,
                                        String receiptUrl, String custom, boolean optoutsFlag, String validity, boolean unicodeFlag,
                                        boolean trackingLinksFlag, String groupId)
            throws TextlocalException, UnsupportedEncodingException {
        validateMessage(message);
        sender = validateSender(sender);
        StringBuffer buffer = new StringBuffer("apikey=");
        buffer.append(this.config.getApiKey());
        buffer.append("&message=");
        buffer.append(URLEncoder.encode(message, "UTF-8"));
        buffer.append("&sender=");
        buffer.append(sender);
        if (numbers != null) {
            validateNumbers(numbers);
            buffer.append("&numbers=");
            buffer.append(Utils.joinStrings(numbers));
        } else {
            buffer.append("&group_id=");
            buffer.append(URLEncoder.encode(groupId, "UTF-8"));
        }
        if (scheduleTime != null) {
            validateUnixTimestamp(scheduleTime);
            buffer.append("&schedule_time=");
            buffer.append(URLEncoder.encode(scheduleTime, "UTF-8"));
        }
        if (receiptUrl != null) {
            validateUrl(receiptUrl);
            buffer.append("&receipt_url=");
            buffer.append(URLEncoder.encode(receiptUrl, "UTF-8"));
        }
        if (custom != null) {
            buffer.append("&custom=");
            buffer.append(URLEncoder.encode(custom, "UTF-8"));
        }
        if (optoutsFlag) {
            buffer.append("&optouts=true");
        }
        if (validity != null) {
            validateUnixTimestamp(validity);
            buffer.append("&validity=");
            buffer.append(URLEncoder.encode(validity, "UTF-8"));
        }
        if (unicodeFlag) {
            buffer.append("&unicode=true");
        }
        if (trackingLinksFlag) {
            buffer.append("&tracking_links=true");
        }
        if (config.getTestMode()) {
            buffer.append("&test=true");
        }
        return buffer;
    }

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime,
                                           String receiptUrl, String custom, boolean optoutsFlag, String validity,
                                           boolean unicodeFlag) throws UnsupportedEncodingException, TextlocalException {
        return sendMessage(message, numbers, sender, scheduleTime, receiptUrl, custom, optoutsFlag, validity,
                unicodeFlag, false);
    }

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime,
                                           String receiptUrl, String custom, boolean optoutsFlag, String validity)
            throws UnsupportedEncodingException, TextlocalException {
        return sendMessage(message, numbers, sender, scheduleTime, receiptUrl, custom, optoutsFlag, validity, false);
    }

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime,
                                           String receiptUrl, String custom, boolean optoutsFlag)
            throws UnsupportedEncodingException, TextlocalException {
        return sendMessage(message, numbers, sender, scheduleTime, receiptUrl, custom, optoutsFlag, null);
    }

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime,
                                           String receiptUrl, String custom)
            throws UnsupportedEncodingException, TextlocalException {
        return sendMessage(message, numbers, sender, scheduleTime, receiptUrl, custom, false);
    }

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime,
                                           String receiptUrl) throws UnsupportedEncodingException, TextlocalException {
        return sendMessage(message, numbers, sender, scheduleTime, receiptUrl, null);
    }

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender, String scheduleTime)
            throws UnsupportedEncodingException, TextlocalException {
        return sendMessage(message, numbers, sender, scheduleTime, null);
    }

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime,
                                           String receiptUrl, String custom, boolean optoutsFlag, String validity,
                                           boolean unicodeFlag, boolean trackingLinksFlag)
            throws TextlocalException, UnsupportedEncodingException {
        StringBuffer buffer = prepareApiCall(message, null, sender, scheduleTime, receiptUrl, custom, optoutsFlag,
                validity, unicodeFlag, trackingLinksFlag, groupId);
        String jsonResponse = sendToApi(config.getSendMessageUrl(), buffer.toString());
        return JsonHelper.extractMessageSentResponse(jsonResponse);
    }

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl,
                                           String custom, boolean optoutsFlag, String validity, boolean unicodeFlag)
            throws TextlocalException, UnsupportedEncodingException {
        return sendMessage(message, groupId, sender, scheduleTime, receiptUrl, custom, optoutsFlag, validity, unicodeFlag, false);
    }

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl,
                                           String custom, boolean optoutsFlag, String validity)
            throws TextlocalException, UnsupportedEncodingException {
        return sendMessage(message, groupId, sender, scheduleTime, receiptUrl, custom, optoutsFlag, validity, false);
    }

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl,
                                           String custom, boolean optoutsFlag)
            throws TextlocalException, UnsupportedEncodingException {
        return sendMessage(message, groupId, sender, scheduleTime, receiptUrl, custom, optoutsFlag, null);
    }

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl,
                                           String custom) throws TextlocalException, UnsupportedEncodingException {
        return sendMessage(message, groupId, sender, scheduleTime, receiptUrl, custom, false);
    }

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime, String receiptUrl)
            throws TextlocalException, UnsupportedEncodingException {
        return sendMessage(message, groupId, sender, scheduleTime, receiptUrl, null);
    }

    public MessageSentResponse sendMessage(String message, String groupId, String sender, String scheduleTime)
            throws TextlocalException, UnsupportedEncodingException {
        return sendMessage(message, groupId, sender, scheduleTime, null);
    }

    public MessageSentResponse sendMessage(String message, String groupId, String sender)
            throws TextlocalException, UnsupportedEncodingException {
        return sendMessage(message, groupId, sender, null);
    }

    private String sendToApi(String url, String data) {
        if (config.getPreferGetMethodOverPost()) {
            return networkHelper.get(url + "?" + data);
        }
        return networkHelper.post(url, data);
    }

    private void validateUrl(String receiptUrl) throws TextlocalException {
        try {
            URL url = new URL(receiptUrl);
            url.toURI();
        } catch (Exception e) {
            throw new TextlocalException(-1, "Invalid URL");
        }
    }

    private void validateUnixTimestamp(String scheduleTime) {
        // TODO - Find and validate the proper format
    }

    private void validateNumbers(List<String> numbers) throws TextlocalException {
        if (numbers.size() == 0) {
            throw new TextlocalException(TextlocalConstants.Errors.NO_RECIPIENTS);
        }
        if (numbers.size() > 10000) {
            throw new TextlocalException(TextlocalConstants.Errors.TOO_MANY_NUMBERS);
        }
    }

    private String validateSender(String sender) {
        if (sender == null || sender.trim().length() == 0) {
            sender = "TXTLCL";
        }
        return sender;
    }

    private void validateMessage(String message) throws TextlocalException {
        if (message == null) {
            throw new TextlocalException(TextlocalConstants.Errors.NO_MESSAGE_CONTENT);
        }
        if (message.length() > 765) {
            throw new TextlocalException(TextlocalConstants.Errors.MESSAGE_TOO_LONG);
        }
    }

    /**
     * This command can be used to create a shortened URL using our built in Short URL Creator.
     *
     * @param urlToConvert
     * @return
     * @throws UnsupportedEncodingException
     * @throws TextlocalException
     */
    public ShortUrlResponse createShortUrl(String urlToConvert) throws UnsupportedEncodingException, TextlocalException {
        validateUrlBeforeConversion(urlToConvert);
        StringBuilder builder = new StringBuilder("apikey=");
        builder.append(this.config.getApiKey());
        builder.append("&url=");
        builder.append(URLEncoder.encode(urlToConvert, "UTF-8"));
        String response = null;
        if (this.config.getPreferGetMethodOverPost()) {
            response = networkHelper.get(this.config.getCreateShortUrl() + "?" + builder.toString());
        } else {
            response = networkHelper.post(this.config.getCreateShortUrl(), builder.toString());
        }
        return JsonHelper.extractShortUrlResponse(response);
    }

    private void validateUrlBeforeConversion(String urlToConvert) throws TextlocalException {
        if (urlToConvert == null || (urlToConvert != null && urlToConvert.trim().length() == 0)) {
            throw new TextlocalException(TextlocalConstants.Errors.NO_URL_SPECIFIED);
        }
    }
}
