package com.shailahir.apps.textlocal.api.exception;

import com.shailahir.apps.textlocal.api.constants.TextlocalConstants;

public class TextlocalException extends Exception {
    private int errorCode;
    private String errorMessage;

    public TextlocalException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public TextlocalException() {

    }

    public TextlocalException(TextlocalConstants.Errors error) {
        if (error != null) {
            this.errorCode = error.getErrorCode();
            this.errorMessage = error.getErrorMessage();
        }
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
