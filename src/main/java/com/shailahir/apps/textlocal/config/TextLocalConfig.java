package com.shailahir.apps.textlocal.config;

public class TextLocalConfig {
    private String apiKey;
    private boolean preferGetMethodOverPost;
    private boolean testMode;
    private String sendMessageUrl = "https://api.textlocal.in/send";
    private String createShortUrl = "https://api.textlocal.in/create_shorturl";
    private String getContactsUrl = "https://api.textlocal.in/get_contacts";
    private String getGroupsUrl = "https://api.textlocal.in/get_groups";
    private String createGroupUrl = "https://api.textlocal.in/create_group";
    private String deleteGroupUrl = "https://api.textlocal.in/delete_group";
    private String createContactUrl = "https://api.textlocal.in/create_contacts";

    public TextLocalConfig() {

    }

    public TextLocalConfig(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setPreferGetMethodOverPost(boolean value) {
        this.preferGetMethodOverPost = value;
    }

    public boolean getPreferGetMethodOverPost() {
        return this.preferGetMethodOverPost;
    }

    public boolean getTestMode() {
        return this.testMode;
    }

    public void setTestMode(boolean value) {
        this.testMode = value;
    }

    public void setSendMessageUrl(String url) {
        this.sendMessageUrl = url;
    }

    public String getSendMessageUrl() {
        return this.sendMessageUrl;
    }


    public void setUrlShortenUrl(String url) {
        this.createShortUrl = url;
    }

    public String getCreateShortUrl() {
        return createShortUrl;
    }

    public String getGetContactsUrl() {
        return getContactsUrl;
    }

    public void setGetContactsUrl(String getContactsUrl) {
        this.getContactsUrl = getContactsUrl;
    }

    public String getGetGroupsUrl() {
        return getGroupsUrl;
    }

    public void setGetGroupsUrl(String getGroupsUrl) {
        this.getGroupsUrl = getGroupsUrl;
    }

    public String getCreateGroupUrl() {
        return createGroupUrl;
    }

    public void setCreateGroupUrl(String createGroupUrl) {
        this.createGroupUrl = createGroupUrl;
    }

    public String getDeleteGroupUrl() {
        return deleteGroupUrl;
    }

    public void setDeleteGroupUrl(String deleteGroupUrl) {
        this.deleteGroupUrl = deleteGroupUrl;
    }

    public String getCreateContactUrl() {
        return createContactUrl;
    }

    public void setCreateContactUrl(String createContactUrl) {
        this.createContactUrl = createContactUrl;
    }
}
