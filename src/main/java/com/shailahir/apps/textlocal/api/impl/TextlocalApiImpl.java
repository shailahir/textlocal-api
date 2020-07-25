package com.shailahir.apps.textlocal.api.impl;

import com.shailahir.apps.textlocal.api.TextlocalApi;
import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.config.TextLocalConfig;

public class TextlocalApiImpl implements TextlocalApi {

    private TextLocalConfig config;

    public TextlocalApiImpl(TextLocalConfig config) throws TextlocalException {
        if (config == null || config.getApiKey() == null || config.getApiKey().trim().length() == 0) {
            throw new TextlocalException(60, "Textlocal Config is not valid");
        }
        this.config = config;
    }

}
