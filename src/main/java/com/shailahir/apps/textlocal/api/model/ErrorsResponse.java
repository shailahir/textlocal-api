package com.shailahir.apps.textlocal.api.model;

import java.util.List;

public class ErrorsResponse {
    private String status;
    private List<Error> errors;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ErrorsResponse{" +
                "status='" + status + '\'' +
                ", errors=" + errors +
                '}';
    }
}
