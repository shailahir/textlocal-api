package com.shailahir.apps.textlocal.api.model;

public class Contact {
    private String number;
    private String firstName;
    private String lastName;
    private String custom1;
    private String custom2;
    private String custom3;

    public Contact() {
    }

    public Contact(String number, String firstName, String lastName, String custom1, String custom2, String custom3) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.custom1 = custom1;
        this.custom2 = custom2;
        this.custom3 = custom3;
    }

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
}
