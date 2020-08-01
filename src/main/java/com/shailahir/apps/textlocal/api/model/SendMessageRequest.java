package com.shailahir.apps.textlocal.api.model;

import java.util.Collections;
import java.util.List;

public class SendMessageRequest {
    private int groupId;
    private String message;
    private List<String> numbers;
    private String sender;
    private String scheduleTime;
    private String receiptUrl;
    private String custom;
    private boolean optOutsFlag;
    private String validity;
    private boolean unicodeFlag;
    private boolean trackingLinksFlag;

    public SendMessageRequest(Builder builder) {
        this.groupId = builder.groupId;
        this.message = builder.message;
        this.numbers = builder.numbers;
        this.sender = builder.sender;
        this.scheduleTime = builder.scheduleTime;
        this.receiptUrl = builder.receiptUrl;
        this.custom = builder.custom;
        this.optOutsFlag = builder.optOutsFlag;
        this.validity = builder.validity;
        this.unicodeFlag = builder.unicodeFlag;
        this.trackingLinksFlag = builder.trackingLinksFlag;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getNumbers() {
        return numbers != null ? Collections.unmodifiableList(numbers) : null;
    }

    public String getSender() {
        return sender;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public String getCustom() {
        return custom;
    }

    public boolean isOptOutsFlag() {
        return optOutsFlag;
    }

    public String getValidity() {
        return validity;
    }

    public boolean isUnicodeFlag() {
        return unicodeFlag;
    }

    public boolean isTrackingLinksFlag() {
        return trackingLinksFlag;
    }

    public static class Builder {
        private int groupId;
        private String message;
        private List<String> numbers;
        private String sender;
        private String scheduleTime;
        private String receiptUrl;
        private String custom;
        private boolean optOutsFlag;
        private String validity;
        private boolean unicodeFlag;
        private boolean trackingLinksFlag;

        private Builder() {

        }

        public static Builder newInstance() {
            return new Builder();
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setNumbers(List<String> numbers) {
            this.numbers = numbers;
            return this;
        }

        public Builder setSender(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder setScheduleTime(String scheduleTime) {
            this.scheduleTime = scheduleTime;
            return this;
        }

        public Builder setReceiptUrl(String receiptUrl) {
            this.receiptUrl = receiptUrl;
            return this;
        }

        public Builder setCustom(String custom) {
            this.custom = custom;
            return this;
        }

        public Builder setOptOutsFlag(boolean optOutsFlag) {
            this.optOutsFlag = optOutsFlag;
            return this;
        }

        public Builder setValidity(String validity) {
            this.validity = validity;
            return this;
        }

        public Builder setUnicodeFlag(boolean unicodeFlag) {
            this.unicodeFlag = unicodeFlag;
            return this;
        }

        public Builder setTrackingLinksFlag(boolean trackingLinksFlag) {
            this.trackingLinksFlag = trackingLinksFlag;
            return this;
        }

        public SendMessageRequest build() {
            return new SendMessageRequest(this);
        }
    }
}
