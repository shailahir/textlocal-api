package com.shailahir.apps.textlocal.api;

import com.shailahir.apps.textlocal.api.model.Contact;

public interface TextLocalContacts {
    void createContact(String[] numbers, String groupId);

    void createGroup(String groupName);

    void getContacts(String groupId, int limit);

    void bulkCreateContacts(Contact[] contacts, String groupId);
}
