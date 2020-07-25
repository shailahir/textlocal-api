package com.shailahir.apps.textlocal.config;

public class TextLocalConfig {
    private String apiKey;
    private boolean preferGetMethodOverPost;

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
}
