package com.shailahir.apps.textlocal.api.model;

import com.google.gson.annotations.SerializedName;

public class Contact {
    private String number;
    @SerializedName(value = "first_name", alternate = "firstName")
    private String firstName;
    @SerializedName(value = "last_name", alternate = "lastName")
    private String lastName;
    private String custom1;
    private String custom2;
    private String custom3;
    private String linkTracking;
    private String groupID;
    private String id;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getLinkTracking() {
        return linkTracking;
    }

    public void setLinkTracking(String linkTracking) {
        this.linkTracking = linkTracking;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "number='" + number + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", custom1='" + custom1 + '\'' +
                ", custom2='" + custom2 + '\'' +
                ", custom3='" + custom3 + '\'' +
                ", linkTracking='" + linkTracking + '\'' +
                ", groupID='" + groupID + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
