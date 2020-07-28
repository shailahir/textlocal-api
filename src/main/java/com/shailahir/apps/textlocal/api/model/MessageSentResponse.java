package com.shailahir.apps.textlocal.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessageSentResponse extends BaseResponse {
    @SerializedName("test_mode")
    private boolean testMode;
    private int balance;

    @SerializedName("batch_id")
    private int batchId;
    private int cost;

    @SerializedName("num_messages")
    private int numMessages;
    private SentMessageMetadata message;

    @SerializedName("receipt_url")
    private String receiptUrl;
    private String custom;
    private List<SentMessage> messages;

    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumMessages() {
        return numMessages;
    }

    public void setNumMessages(int numMessages) {
        this.numMessages = numMessages;
    }

    public SentMessageMetadata getMessage() {
        return message;
    }

    public void setMessage(SentMessageMetadata message) {
        this.message = message;
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public void setReceiptUrl(String receiptUrl) {
        this.receiptUrl = receiptUrl;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public List<SentMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<SentMessage> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "MessageSentResponse{" +
                "testMode=" + testMode +
                ", balance=" + balance +
                ", batchId=" + batchId +
                ", cost=" + cost +
                ", numMessages=" + numMessages +
                ", message=" + message +
                ", receiptUrl='" + receiptUrl + '\'' +
                ", custom='" + custom + '\'' +
                ", messages=" + messages +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
