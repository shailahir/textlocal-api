package com.shailahir.apps.textlocal.api.model;

import com.google.gson.annotations.SerializedName;

public class ShortUrlResponse extends BaseResponse {
    @SerializedName("shorturl")
    private String shortUrl;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "ShortUrlResponse{" +
                "shortUrl='" + shortUrl + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
