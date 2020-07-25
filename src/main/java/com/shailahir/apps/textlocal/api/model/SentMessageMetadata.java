package com.shailahir.apps.textlocal.api.model;

import com.google.gson.annotations.SerializedName;

public class SentMessageMetadata {
    @SerializedName("num_parts")
    private int numParts;

    private String sender;
    private String content;

    public int getNumParts() {
        return numParts;
    }

    public void setNumParts(int numParts) {
        this.numParts = numParts;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
