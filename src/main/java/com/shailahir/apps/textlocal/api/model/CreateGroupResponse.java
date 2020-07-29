package com.shailahir.apps.textlocal.api.model;

public class CreateGroupResponse extends BaseResponse {
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "CreateGroupResponse{" +
                "group=" + group +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
