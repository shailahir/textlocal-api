package com.shailahir.apps.textlocal.api.impl;

import com.google.gson.Gson;
import com.shailahir.apps.textlocal.api.TextLocalApi;
import com.shailahir.apps.textlocal.api.constants.TextlocalConstants;
import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.api.model.*;
import com.shailahir.apps.textlocal.config.TextLocalConfig;
import com.shailahir.apps.textlocal.utils.JsonHelper;
import com.shailahir.apps.textlocal.utils.NetworkHelper;
import com.shailahir.apps.textlocal.utils.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

public class TextLocalApiImpl implements TextLocalApi {

    public static final String GROUP_ID = "&group_id=";
    public static final String CONTACTS = "&contacts=";
    public static final String APIKEY = "apikey=";
    public static final String NUMBER = "&number=";
    public static final String NUMBERS = "&numbers=";
    public static final String NAME = "&name=";
    public static final String UTF_8 = "UTF-8";
    public static final String LIMIT = "&limit=";
    public static final String TXTLCL = "TXTLCL";
    public static final String MESSAGE = "&message=";
    public static final String SENDER = "&sender=";
    public static final String SCHEDULE_TIME = "&schedule_time=";
    public static final String RECEIPT_URL = "&receipt_url=";
    public static final String CUSTOM = "&custom=";
    public static final String OPTOUTS_TRUE = "&optouts=true";
    public static final String VALIDITY = "&validity=";
    public static final String UNICODE_TRUE = "&unicode=true";
    public static final String TRACKING_LINKS_TRUE = "&tracking_links=true";
    public static final String TEST_TRUE = "&test=true";
    private final TextLocalConfig config;
    private final NetworkHelper networkHelper;

    public TextLocalApiImpl(TextLocalConfig config) throws TextlocalException {
        if (config == null || config.getApiKey() == null || config.getApiKey().trim().length() == 0) {
            throw new TextlocalException(TextlocalConstants.Errors.INVALID_CONFIG);
        }
        this.config = config;
        networkHelper = new NetworkHelper();
    }

    @Override
    public MessageSentResponse sendMessage(SendMessageRequest request) throws TextlocalException, UnsupportedEncodingException {
        if (request != null) {
            validateMessage(request.getMessage());
            String sender = validateSender(request.getSender());
            StringBuffer buffer = new StringBuffer(APIKEY);
            buffer.append(this.config.getApiKey());
            buffer.append(MESSAGE);
            buffer.append(URLEncoder.encode(request.getMessage(), UTF_8));
            buffer.append(SENDER);
            buffer.append(sender);
            if (request.getNumbers() != null) {
                validateNumbers(request.getNumbers());
                buffer.append(NUMBERS);
                buffer.append(Utils.joinStrings(request.getNumbers()));
            } else {
                buffer.append(GROUP_ID);
                buffer.append(URLEncoder.encode(String.valueOf(request.getGroupId()), UTF_8));
            }
            if (request.getScheduleTime() != null) {
                validateUnixTimestamp(request.getScheduleTime());
                buffer.append(SCHEDULE_TIME);
                buffer.append(URLEncoder.encode(request.getScheduleTime(), UTF_8));
            }
            if (request.getReceiptUrl() != null) {
                validateUrl(request.getReceiptUrl());
                buffer.append(RECEIPT_URL);
                buffer.append(URLEncoder.encode(request.getReceiptUrl(), UTF_8));
            }
            if (request.getCustom() != null) {
                buffer.append(CUSTOM);
                buffer.append(URLEncoder.encode(request.getCustom(), UTF_8));
            }
            if (request.isOptOutsFlag()) {
                buffer.append(OPTOUTS_TRUE);
            }
            if (request.getValidity() != null) {
                validateUnixTimestamp(request.getValidity());
                buffer.append(VALIDITY);
                buffer.append(URLEncoder.encode(request.getValidity(), UTF_8));
            }
            if (request.isUnicodeFlag()) {
                buffer.append(UNICODE_TRUE);
            }
            if (request.isTrackingLinksFlag()) {
                buffer.append(TRACKING_LINKS_TRUE);
            }
            if (config.getTestMode()) {
                buffer.append(TEST_TRUE);
            }
            String response = sendToApi(config.getSendMessageUrl(), buffer.toString());
            JsonHelper.handleResponse(response);
            return JsonHelper.parse(response, MessageSentResponse.class);
        }
        return null;
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
            sender = TXTLCL;
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
        StringBuilder builder = new StringBuilder(APIKEY);
        builder.append(this.config.getApiKey());
        builder.append("&url=");
        builder.append(URLEncoder.encode(urlToConvert, UTF_8));
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

    /**
     * This command can be used to retrieve all contacts within a group.
     *
     * @param groupId ID of the group. Can either be found within Messenger (in the "Reports" - "Advanced Reports" - "List of Group ID's" section)
     *                or by running the get_groups command. Additionally group 5 contains "contacts" and group 6 contains "opt-outs".
     * @param limit   max number of records to return
     * @return GetContactsResponse
     */
    public GetContactsResponse getContactsByGroupId(String groupId, int limit) throws TextlocalException {
        if (groupId != null && groupId.trim().length() > 0) {
            StringBuilder builder = new StringBuilder(APIKEY);
            builder.append(this.config.getApiKey());
            builder.append(GROUP_ID);
            builder.append(groupId);
            builder.append(LIMIT);
            builder.append(limit == 0 ? 100 : limit);
            String response = sendToApi(config.getGetContactsUrl(), builder.toString());
            JsonHelper.handleResponse(response);
            return JsonHelper.parse(response, GetContactsResponse.class);
        }
        throw new TextlocalException(TextlocalConstants.Errors.NO_GROUP_ID_SPECIFIED);
    }

    /**
     * This command can be used to retrieve all contacts within a group that have this number.
     *
     * @param groupId ID of the group. Can either be found within Messenger (in the "Reports" - "Advanced Reports" - "List of Group ID's" section)
     *                or by running the get_groups command. Additionally group 5 contains "contacts" and group 6 contains "opt-outs".
     * @param number  A specific number that you want to retrieve from the specified group. Using this parameter will also return a Link Tracking
     *                parameter for sending out pre-created surveys via the API.
     * @param limit   max number of records to return
     * @return
     * @throws TextlocalException
     */
    public GetContactsResponse getContactsByGroupIdAndNumber(String groupId, String number, int limit) throws TextlocalException {
        if (groupId != null && groupId.trim().length() > 0) {
            validateNumbers(Arrays.asList(new String[]{number}));
            StringBuilder builder = new StringBuilder(APIKEY);
            builder.append(this.config.getApiKey());
            builder.append(GROUP_ID);
            builder.append(groupId);
            builder.append(NUMBER);
            builder.append(number);
            builder.append(LIMIT);
            builder.append(limit == 0 ? 100 : limit);
            String response = sendToApi(config.getGetContactsUrl(), builder.toString());
            JsonHelper.handleResponse(response);
            return JsonHelper.parse(response, GetContactsResponse.class);
        }
        throw new TextlocalException(TextlocalConstants.Errors.NO_GROUP_ID_SPECIFIED);
    }

    /**
     * This command can be used to get a detailed list of contact groups.
     *
     * @return
     * @throws TextlocalException
     */
    public GetGroupsResponse getGroups() throws TextlocalException {
        StringBuilder builder = new StringBuilder(APIKEY);
        builder.append(config.getApiKey());
        String response = sendToApi(config.getGetGroupsUrl(), builder.toString());
        JsonHelper.handleResponse(response);
        return JsonHelper.parse(response, GetGroupsResponse.class);
    }

    /**
     * This command can be used to create a group within your Textlocal account.
     *
     * @param groupName Name of the new group.
     * @return
     */
    public CreateGroupResponse createGroups(String groupName) throws TextlocalException, UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder(APIKEY);
        builder.append(config.getApiKey());
        builder.append(NAME);
        builder.append(URLEncoder.encode(groupName, UTF_8));
        String response = sendToApi(config.getCreateGroupUrl(), builder.toString());
        JsonHelper.handleResponse(response);
        return JsonHelper.parse(response, CreateGroupResponse.class);
    }

    /**
     * This function will delete a contact group, including the contacts within it.
     *
     * @param groupId ID of the group. Can either be found within Messenger (in the "Reports" - "Advanced Reports" -
     *                "List of Group ID's" section) or by running the get_groups command. Additionally group 5 contains
     *                "contacts" and group 6 contains "opt-outs".
     * @return
     */
    public BaseResponse deleteGroup(String groupId) throws TextlocalException {
        StringBuilder builder = new StringBuilder(APIKEY);
        builder.append(config.getApiKey());
        builder.append(GROUP_ID);
        builder.append(groupId);
        String response = sendToApi(config.getDeleteGroupUrl(), builder.toString());
        JsonHelper.handleResponse(response);
        return JsonHelper.parse(response, BaseResponse.class);
    }

    /**
     * This command can be used to insert new numbers into your Textlocal contact groups.
     *
     * @param groupId ID of the group. Can either be found within Messenger (in the "Reports" - "Advanced Reports" -
     *                "List of Group ID's" section) or by running the get_groups command. Additionally group 5 contains "contacts"
     * @param numbers Comma-delimited list of mobile numbers in international format (i.e. 918123456789).
     * @return
     */
    public CreateContactResponse createContact(String groupId, List<String> numbers) throws TextlocalException {
        validateNumbers(numbers);
        StringBuilder builder = new StringBuilder(APIKEY);
        builder.append(config.getApiKey());
        builder.append(NUMBERS);
        builder.append(Utils.joinStrings(numbers));
        builder.append(GROUP_ID);
        builder.append(groupId);
        String response = sendToApi(config.getCreateContactUrl(), builder.toString());
        JsonHelper.handleResponse(response);
        return JsonHelper.parse(response, CreateContactResponse.class);
    }

    /**
     * This command will remove a contact from a specific group.
     *
     * @param groupId ID of the group. Can either be found within Messenger (in the "Reports" - "Advanced Reports" -
     *                "List of Group ID's" section) or by running the get_groups command. Additionally group 5 contains
     *                "contacts" and group 6 contains "opt-outs".
     * @param number  Mobile number of the contact to be deleted in international format (i.e. 918123456789).
     * @return
     * @throws TextlocalException
     */
    public DeleteContactResponse deleteContact(String groupId, String number) throws TextlocalException {
        StringBuilder builder = new StringBuilder(APIKEY);
        builder.append(config.getApiKey());
        builder.append(GROUP_ID);
        builder.append(groupId);
        builder.append(NUMBER);
        builder.append(number);
        String response = sendToApi(config.getDeleteContactUrl(), builder.toString());
        JsonHelper.handleResponse(response);
        return JsonHelper.parse(response, DeleteContactResponse.class);
    }

    public CreateBulkContactResponse createBulkContacts(String groupId, List<Contact> contacts) throws TextlocalException {
        StringBuilder builder = new StringBuilder(APIKEY);
        builder.append(config.getApiKey());
        builder.append(GROUP_ID);
        builder.append(groupId);
        builder.append(CONTACTS);
        builder.append(new Gson().toJson(contacts));
        String response = sendToApi(config.getCreateBulkContactUrl(), builder.toString());
        JsonHelper.handleResponse(response);
        return JsonHelper.parse(response, CreateBulkContactResponse.class);
    }
}
