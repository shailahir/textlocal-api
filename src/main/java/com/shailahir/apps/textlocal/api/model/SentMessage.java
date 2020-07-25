package com.shailahir.apps.textlocal.api.model;

public class SentMessage {
    private int id;
    private long recipient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRecipient() {
        return recipient;
    }

    public void setRecipient(long recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "SentMessage{" +
                "id=" + id +
                ", recipient=" + recipient +
                '}';
    }
}
