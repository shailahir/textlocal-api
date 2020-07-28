package com.shailahir.apps.textlocal.config;

public class TextLocalConfig {
    private String apiKey;
    private boolean preferGetMethodOverPost;
    private boolean testMode;
    private String sendMessageUrl = "https://api.textlocal.in/send";
    private String createShortUrl = "https://api.textlocal.in/create_shorturl";

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
}
