package com.shailahir.apps.textlocal.api.impl;

import com.shailahir.apps.textlocal.api.TextlocalApi;
import com.shailahir.apps.textlocal.api.constants.TextlocalConstants;
import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.api.model.MessageSentResponse;
import com.shailahir.apps.textlocal.config.TextLocalConfig;
import com.shailahir.apps.textlocal.utils.JsonHelper;
import com.shailahir.apps.textlocal.utils.NetworkHelper;
import com.shailahir.apps.textlocal.utils.Utils;

import java.io.UnsupportedEncodingException;
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

    public MessageSentResponse sendMessage(String message, List<String> numbers, String sender) throws TextlocalException, UnsupportedEncodingException {
        validateMessage(message);
        sender = validateSender(sender);
        validateNumbers(numbers);
        StringBuffer buffer = new StringBuffer("apikey=");
        buffer.append(this.config.getApiKey());
        buffer.append("&message=");
        buffer.append(URLEncoder.encode(message, "UTF-8"));
        buffer.append("&sender=");
        buffer.append(sender);
        buffer.append("&numbers=");
        buffer.append(Utils.joinStrings(numbers));
        if (config.getTestMode()) {
            buffer.append("&test=true");
        }
        String jsonResponse = sendToApi(config.getSendMessageUrl(), buffer.toString());
        return JsonHelper.extractMessageSentResponse(jsonResponse);
    }

    private String sendToApi(String url, String data) {
        if (config.getPreferGetMethodOverPost()) {
            return networkHelper.get(url + "?" + data);
        }
        return networkHelper.post(url, data);
    }

    private void validateNumbers(List<String> numbers) throws TextlocalException {
        if (numbers == null || numbers.size() == 0) {
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
}
