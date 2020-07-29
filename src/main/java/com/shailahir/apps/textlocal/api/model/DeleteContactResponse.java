package com.shailahir.apps.textlocal.api.model;

import com.google.gson.annotations.SerializedName;

public class DeleteContactResponse extends BaseResponse {
    @SerializedName(value = "group_id", alternate = "groupId")
    private int groupId;
    private long number;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "DeleteContactResponse{" +
                "groupId=" + groupId +
                ", number=" + number +
                ", status=" + getStatus() +
                '}';
    }
}
