package com.shailahir.apps.textlocal.utils;

import com.google.gson.Gson;
import com.shailahir.apps.textlocal.api.constants.TextlocalConstants;
import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.api.model.ErrorsResponse;

import java.util.HashMap;

public class JsonHelper {

    public static void handleResponse(String json) throws TextlocalException {
        Gson gson = new Gson();
        HashMap hashMap = gson.fromJson(json, HashMap.class);
        if (hashMap != null && hashMap.get("status") == "failure") {
            ErrorsResponse errors = gson.fromJson(json, ErrorsResponse.class);
            if (errors != null && errors.getErrors() != null && errors.getErrors().size() > 0) {
                throw new TextlocalException(TextlocalConstants.Errors.byCode(errors.getErrors().get(0).getCode()));
            }
        }
    }

    public static <T> T parse(String response, Class<T> claz) {
        return new Gson().fromJson(response, claz);
    }
}
