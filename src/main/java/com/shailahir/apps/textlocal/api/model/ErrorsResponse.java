package com.shailahir.apps.textlocal.api.model;

import java.util.List;

public class ErrorsResponse extends BaseResponse {
    private List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ErrorsResponse{" +
                "status='" + getStatus() + '\'' +
                ", errors=" + errors +
                '}';
    }
}
