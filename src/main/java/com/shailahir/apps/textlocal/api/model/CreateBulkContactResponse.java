package com.shailahir.apps.textlocal.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateBulkContactResponse extends BaseResponse {
    private List<Contact> contacts;
    @SerializedName(value = "group_id", alternate = "groupId")
    private int groupId;
    @SerializedName(value = "num_contacts", alternate = "numOfContacts")
    private int numOfContacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getNumOfContacts() {
        return numOfContacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setNumOfContacts(int numOfContacts) {
        this.numOfContacts = numOfContacts;
    }

    @Override
    public String toString() {
        return "CreateBulkContactResponse{" +
                "contacts=" + contacts +
                ", groupId=" + groupId +
                ", numOfContacts=" + numOfContacts +
                ", success=" + getStatus() +
                '}';
    }
}
