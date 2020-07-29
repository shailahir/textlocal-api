package com.shailahir.apps.textlocal.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetContactsResponse extends BaseResponse {
    @SerializedName("group_id")
    private int groupId;
    private int start;
    private int limit;
    @SerializedName("num_contacts")
    private int numOfContacts;
    private List<Contact> contacts;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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
        return "GetContactsResponse{" +
                "groupId=" + groupId +
                ", start=" + start +
                ", limit=" + limit +
                ", numOfContacts=" + numOfContacts +
                ", contacts=" + contacts +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
