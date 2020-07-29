package com.shailahir.apps.textlocal.api.impl;

import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.api.model.*;
import com.shailahir.apps.textlocal.config.TextLocalConfig;
import com.shailahir.apps.textlocal.utils.TestConfigReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class TextLocalApiImplTests {

    private TextLocalApiImpl target;

    @Before
    public void setup() throws TextlocalException {
        TextLocalConfig config = new TextLocalConfig();
        config.setApiKey(TestConfigReader.getApiKey());
        config.setPreferGetMethodOverPost(false);
        config.setTestMode(true);
        target = new TextLocalApiImpl(config);
    }

    @Test
    public void testTargetIsNotNull() {
        assertNotNull(target);
    }

    @Test
    public void createTargetWithConfig() throws TextlocalException {
        TextLocalConfig config = new TextLocalConfig();
        config.setApiKey(TestConfigReader.getApiKey());
        config.setPreferGetMethodOverPost(false);
        target = new TextLocalApiImpl(config);
    }

    @Test(expected = TextlocalException.class)
    public void testConfigIsNull() throws TextlocalException {
        target = new TextLocalApiImpl(null);
    }

    @Test(expected = TextlocalException.class)
    public void testConfigIsInvalid() throws TextlocalException {
        TextLocalConfig config = new TextLocalConfig();
        target = new TextLocalApiImpl(config);
    }

    @Ignore
    @Test
    public void createMessageRequest() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
        numbers.add(TestConfigReader.getMobileNumber());
        SendMessageRequest request = SendMessageRequest.Builder.newInstance()
                .setMessage("Message Content")
                .setNumbers(numbers)
                .build();
        MessageSentResponse result = target.sendMessage(request);
        assertNotNull(result);
        assertEquals("success", result.getStatus());
    }

    @Test
    public void sendMessage3Params() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
        numbers.add(TestConfigReader.getMobileNumber());
//        target.sendMessage("Test Content", numbers, null);
    }

    @Ignore
    @Test(expected = TextlocalException.class)
    public void sendMessageInvalidMessageContent() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
        numbers.add(TestConfigReader.getMobileNumber());
//        target.sendMessage(null, numbers, null);
    }

    @Ignore
    @Test(expected = TextlocalException.class)
    public void sendMessageInvalidMessageContentTooLong() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
        numbers.add(TestConfigReader.getMobileNumber());
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nec magna quis nisi dictum cursus " +
                "ut vitae arcu. Maecenas malesuada lorem eu ultrices iaculis. Cras lobortis mauris sed consequat feugiat. " +
                "Nulla facilisi. Fusce mattis lacus lectus, vitae aliquet enim lobortis a. Cras sagittis orci ac ipsum vehicula" +
                " ornare. Suspendisse eleifend magna et ligula fringilla dictum. Maecenas blandit malesuada mauris, ut aliquet " +
                "diam efficitur eget. Sed efficitur mi eget pellentesque malesuada. Aenean feugiat nec lectus quis suscipit." +
                " Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam porta, turpis eu pretium condimentum, " +
                "nunc nibh cursus massa, eu pretium odio tellus vel turpis. In egestas libero sit amet risus imperdiet, " +
                "placerat tincidunt arcu porta. Phasellus rutrum tristique diam nec varius. Orci varius natoque penatibus " +
                "et magnis dis parturient montes, nascetur ridiculus mus. Ut dignissim, ex in placerat ultrices, lacus " +
                "felis fermentum nisl, eu tempor libero sem quis enim.";
//        target.sendMessage(message, numbers, null);
    }

    @Ignore
    @Test(expected = TextlocalException.class)
    public void sendMessageInvalidNumber() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
//        target.sendMessage("message", numbers, null);
    }

    @Ignore
    @Test(expected = TextlocalException.class)
    public void sendMessageInvalidNumberTooMany() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
        for (int i = 0; i < 10001; i++) {
            numbers.add("123");
        }
//        target.sendMessage("message", numbers, null);
    }

    @Test
    public void sendMessageUsingGetMethod() throws TextlocalException, UnsupportedEncodingException {
        TextLocalConfig config = new TextLocalConfig();
        config.setApiKey(TestConfigReader.getApiKey());
        config.setPreferGetMethodOverPost(true);
        config.setTestMode(true);
        target = new TextLocalApiImpl(config);
        List<String> numbers = new LinkedList<String>();
        numbers.add(TestConfigReader.getMobileNumber());
//        target.sendMessage("Test Content", numbers, null);
    }

    @Ignore
    @Test
    public void sendMessageToGroupId() throws UnsupportedEncodingException, TextlocalException {
//        target.sendMessage("message", "1111010", null);
    }

    @Test
    public void createShortUrlPostMethod() throws TextlocalException, UnsupportedEncodingException {
        TextLocalConfig config = new TextLocalConfig();
        config.setTestMode(true);
        config.setApiKey(TestConfigReader.getApiKey());
        target = new TextLocalApiImpl(config);
        ShortUrlResponse apiResponse = target.createShortUrl("https://google.co.in");
        assertNotNull(apiResponse);
        assertEquals("success", apiResponse.getStatus());
        assertNotNull(apiResponse.getShortUrl());
    }

    @Test
    public void createShortUrlGetMethod() throws TextlocalException, UnsupportedEncodingException {
        TextLocalConfig config = new TextLocalConfig();
        config.setTestMode(true);
        config.setApiKey(TestConfigReader.getApiKey());
        config.setPreferGetMethodOverPost(true);
        target = new TextLocalApiImpl(config);
        ShortUrlResponse apiResponse = target.createShortUrl("https://google.co.in");
        assertNotNull(apiResponse);
        assertEquals("success", apiResponse.getStatus());
        assertNotNull(apiResponse.getShortUrl());
    }

    @Test(expected = TextlocalException.class)
    public void createShortUrlExceptionCase() throws TextlocalException, UnsupportedEncodingException {
        target.createShortUrl("");
    }

    @Test
    public void getContacts() throws TextlocalException {
        GetContactsResponse apiResponse = target.getContactsByGroupId("1111010", 100);
        assertNotNull(apiResponse);
    }

    @Test
    public void getContactsByGroupIdAndNumber() throws TextlocalException {
        GetContactsResponse apiResponse = target.getContactsByGroupIdAndNumber("1111010", "91123456789", 100);
        System.out.println(apiResponse);
        assertNotNull(apiResponse);
    }

    @Test
    public void getGroups() throws TextlocalException {
        GetGroupsResponse apiResponse = target.getGroups();
        assertNotNull(apiResponse);
        assertEquals("success", apiResponse.getStatus());
    }

    @Test
    public void createGroup() throws TextlocalException, UnsupportedEncodingException {
        CreateGroupResponse apiResponse = target.createGroups("TEST2");
        assertNotNull(apiResponse);
        assertEquals("success", apiResponse.getStatus());
        BaseResponse response = target.deleteGroup(apiResponse.getGroup().getId() + "");
        assertNotNull(response);
        assertEquals("success", response.getStatus());
    }

    @Test
    public void deleteGroup() throws UnsupportedEncodingException, TextlocalException {
        CreateGroupResponse cgResponse = target.createGroups("TEST2");
        assertNotNull(cgResponse);
        assertNotNull(cgResponse.getGroup());
        BaseResponse apiResponse = target.deleteGroup(cgResponse.getGroup().getId() + "");
        assertNotNull(apiResponse);
        assertEquals("success", apiResponse.getStatus());
    }

    @Test
    @Ignore
    public void createContact() throws TextlocalException {
        List<String> numbers = new ArrayList<String>();
        numbers.add("919988774455");
        CreateContactResponse apiResponse = target.createContact("1111010", numbers);
        assertNotNull(apiResponse);
        assertEquals("success", apiResponse.getStatus());
    }

    @Test
    public void deleteContact() throws TextlocalException {
        List<String> numbers = new ArrayList<String>();
        numbers.add("919988774456");
        CreateContactResponse apiResponse = target.createContact("1111010", numbers);
        assertNotNull(apiResponse);
        assertEquals("success", apiResponse.getStatus());
        DeleteContactResponse delResponse = target.deleteContact("1111010", "919988774456");
        assertNotNull(delResponse);
        assertEquals("success", delResponse.getStatus());
    }

    @Test
    public void createBulkContacts() throws TextlocalException {
        List<Contact> contacts = new ArrayList<Contact>();
        Contact contact1 = new Contact();
        contact1.setFirstName("First Contact");
        contact1.setLastName("Last1");
        contact1.setNumber("919988776657");
        contacts.add(contact1);
        Contact contact2 = new Contact();
        contact2.setFirstName("Second Contact");
        contact2.setLastName("Last2");
        contact2.setNumber("919988776658");
        contacts.add(contact2);
        CreateBulkContactResponse apiResponse = target.createBulkContacts("1111010", contacts);
        System.out.println(apiResponse);
        assertNotNull(apiResponse);
        assertEquals("success", apiResponse.getStatus());
    }

    @After
    public void tearDown() {
        target = null;
    }

}
