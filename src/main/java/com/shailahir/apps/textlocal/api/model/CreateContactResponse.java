package com.shailahir.apps.textlocal.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateContactResponse extends BaseResponse {
    @SerializedName("group_id")
    private int groupId;

    @SerializedName("num_contacts")
    private int numOfContacts;

    private List<Contact> contacts;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getNumOfContacts() {
        return numOfContacts;
    }

    public void setNumOfContacts(int numOfContacts) {
        this.numOfContacts = numOfContacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "CreateContactResponse{" +
                "groupId=" + groupId +
                ", numOfContacts=" + numOfContacts +
                ", contacts=" + contacts +
                ", status=" + getStatus() +
                '}';
    }
}
