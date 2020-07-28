package com.shailahir.apps.textlocal.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetGroupsResponse extends BaseResponse {
    @SerializedName("num_groups")
    private int numOfGroups;

    private List<Group> groups;

    public int getNumOfGroups() {
        return numOfGroups;
    }

    public void setNumOfGroups(int numOfGroups) {
        this.numOfGroups = numOfGroups;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "GetGroupsResponse{" +
                "numOfGroups=" + numOfGroups +
                ", groups=" + groups +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
