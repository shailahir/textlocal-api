package com.shailahir.apps.textlocal.api;

import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.api.model.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface TextLocalApi {
    MessageSentResponse sendMessage(SendMessageRequest request) throws TextlocalException, UnsupportedEncodingException;

    ShortUrlResponse createShortUrl(String urlToConvert) throws UnsupportedEncodingException, TextlocalException;

    GetContactsResponse getContactsByGroupId(String groupId, int limit) throws TextlocalException;

    GetGroupsResponse getGroups() throws TextlocalException;

    CreateGroupResponse createGroups(String groupName) throws TextlocalException, UnsupportedEncodingException;

    GetContactsResponse getContactsByGroupIdAndNumber(String groupId, String number, int limit) throws TextlocalException;

    CreateContactResponse createContact(String groupId, List<String> numbers) throws TextlocalException;

    DeleteContactResponse deleteContact(String groupId, String number) throws TextlocalException;

    CreateBulkContactResponse createBulkContacts(String groupId, List<Contact> contacts) throws TextlocalException;
}
