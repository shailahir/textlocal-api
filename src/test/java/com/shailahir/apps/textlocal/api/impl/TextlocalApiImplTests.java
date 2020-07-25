package com.shailahir.apps.textlocal.api.impl;

import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.config.TextLocalConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class TextlocalApiImplTests {

    private TextlocalApiImpl target;

    @Before
    public void setup() throws TextlocalException {
        TextLocalConfig config = new TextLocalConfig();
        config.setApiKey("API_KEY");
        config.setPreferGetMethodOverPost(false);
        target = new TextlocalApiImpl(config);
    }

    @Test
    public void testTargetIsNotNull() {
        assertNotNull(target);
    }

    @Test
    public void createTargetWithConfig() throws TextlocalException {
        TextLocalConfig config = new TextLocalConfig();
        config.setApiKey("API_KEY");
        config.setPreferGetMethodOverPost(false);
        target = new TextlocalApiImpl(config);
    }

    @Test(expected = TextlocalException.class)
    public void testConfigIsNull() throws TextlocalException {
        target = new TextlocalApiImpl(null);
    }

    @Test(expected = TextlocalException.class)
    public void testConfigIsInvalid() throws TextlocalException {
        TextLocalConfig config = new TextLocalConfig();
        target = new TextlocalApiImpl(config);
    }

    @After
    public void tearDown() {
        target = null;
    }
}
