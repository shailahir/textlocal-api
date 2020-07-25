package com.shailahir.apps.textlocal.api.impl;

import com.google.gson.Gson;
import com.shailahir.apps.textlocal.api.TextLocalContacts;
import com.shailahir.apps.textlocal.api.model.Contact;
import com.shailahir.apps.textlocal.utils.ConfigHelper;
import com.shailahir.apps.textlocal.utils.NetworkHelper;
import com.shailahir.apps.textlocal.utils.Utils;

public class TextLocalContactsImpl implements TextLocalContacts {
    private static final String GET_CONTACT = "https://api.textlocal.in/get_contacts/";
    private static final String CREATE_CONTACT = "https://api.textlocal.in/create_contacts/";
    private static final String CREATE_GROUP = "http://api.textlocal.in/create_group?";
    private static final String BULK_CREATE_CONTACT = "https://api.textlocal.in/create_contacts_bulk/";

    /**
     * This command can be used to insert new numbers into your Textlocal contact groups.
     *
     * @param numbers
     * @param groupId
     */
    public void createContact(String[] numbers, String groupId) {
        if (numbers == null || numbers.length == 0 || groupId == null || groupId.trim() == "") {
            return;
        }
        String apiKey = "apikey=" + ConfigHelper.getApiKey();
        String nums = "&numbers=" + Utils.joinStrings(numbers);
        String group_id = "&group_id=" + groupId;
        String data = apiKey + nums + group_id;
        NetworkHelper networkHelper = new NetworkHelper();
        String response = networkHelper.post(CREATE_CONTACT, data);
        System.out.println(response);
    }

    public void createGroup(String groupName) {
        if (groupName == null || groupName.trim().length() == 0) {
            return;
        }
        String apiKey = "apikey=" + ConfigHelper.getApiKey();
        String group_name = "&group_name=" + groupName;
        String data = apiKey + group_name;

        NetworkHelper networkHelper = new NetworkHelper();
        String response = networkHelper.post(CREATE_GROUP, data);
        System.out.println("response " + response);
    }

    public void getContacts(String groupId, int limit) {
        String apiKey = "apikey=" + ConfigHelper.getApiKey();
        String group_id = "&group_id=" + groupId;
        String limitStr = "&limit=" + limit;
        String data = apiKey + group_id + limitStr;
        NetworkHelper networkHelper = new NetworkHelper();
        String response = networkHelper.post(GET_CONTACT, data);
        System.out.println("response " + response);
    }

    public void bulkCreateContacts(Contact[] contacts, String groupId) {
        String apiKey = "apikey=" + ConfigHelper.getApiKey();
        String groupid = "&group_id=" + groupId;
        String finalData = "&contacts=" + new Gson().toJson(contacts);
        String data = apiKey + groupid + finalData;
        NetworkHelper networkHelper = new NetworkHelper();
        String response = networkHelper.post(BULK_CREATE_CONTACT, data);
        System.out.println("response " + response);
    }

    public static void main(String[] args) {
        TextLocalContactsImpl contacts = new TextLocalContactsImpl();
//        contacts.createGroup("Group1");
//        contacts.createContact(new String[] {"919079058166"}, "1111010");
        Contact[] contacts1 = new Contact[2];
        Contact contact1 = new Contact();
        contact1.setFirstName("SA");
        contact1.setNumber("911234567890");
        contacts1[0] = contact1;

        Contact contact2 = new Contact();
        contact2.setFirstName("NA");
        contact2.setNumber("911234567899");
        contacts1[1] = contact2;

        contacts.bulkCreateContacts(contacts1, "1111010");

//        contacts.getContacts("1111010", 100);
    }
}
