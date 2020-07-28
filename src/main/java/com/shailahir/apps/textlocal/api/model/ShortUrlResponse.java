package com.shailahir.apps.textlocal.api.model;

import com.google.gson.annotations.SerializedName;

public class ShortUrlResponse {
    @SerializedName("shorturl")
    private String shortUrl;
    private String status;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShortUrlResponse{" +
                "shortUrl='" + shortUrl + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
