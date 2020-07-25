package com.shailahir.apps.textlocal.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TextLocalConfigTests {

    private TextLocalConfig target;

    @Before
    public void setup() {
        target = new TextLocalConfig();
    }

    @Test
    public void targetIsNotNull() {
        assertNotNull(target);
    }

    @Test
    public void testHasConstructorForApiKey() {
        String val = "API_KEY";
        target = new TextLocalConfig(val);
        assertEquals(val, target.getApiKey());
    }

    @Test
    public void testCanSetApiKeyOnTarget() {
        String val = "API_KEY";
        target.setApiKey(val);
        assertEquals(val, target.getApiKey());
    }

    @Test
    public void testSetPreferGetMethod() {
        target.setPreferGetMethodOverPost(true);
        assertTrue(target.getPreferGetMethodOverPost());
    }

    @Test
    public void testSetSendMessageUrl() {
        String URL = "https://api.textlocal.in/send/";
        target.setSendMessageUrl(URL);
        assertEquals(URL, target.getSendMessageUrl());
    }

    @Test
    public void testApiIsInTestMode() {
        target.setTestMode(true);
        assertTrue(target.getTestMode());
    }

    @After
    public void tearDown() {
        target = null;
    }
}
