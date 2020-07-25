package com.shailahir.apps.textlocal.api.exception;

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
    
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
