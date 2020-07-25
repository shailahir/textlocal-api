package com.shailahir.apps.textlocal.api.constants;

public class TextlocalConstants {

    public enum Errors {
        INVALID_CONFIG(60, "Textlocal Config is not valid"),
        NO_MESSAGE_CONTENT(5, "No message content"),
        MESSAGE_TOO_LONG(6, "Message too long"),
        NO_RECIPIENTS(4, "No recipients specified"),
        TOO_MANY_NUMBERS(33, "You have supplied too many numbers");

        private int errorCode;
        private String errorMessage;

        Errors(int errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
