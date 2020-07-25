package com.shailahir.apps.textlocal.api.impl;

import com.shailahir.apps.textlocal.api.exception.TextlocalException;
import com.shailahir.apps.textlocal.config.TextLocalConfig;
import com.shailahir.apps.textlocal.utils.TestConfigReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class TextlocalApiImplTests {

    private TextlocalApiImpl target;

    @Before
    public void setup() throws TextlocalException {
        TextLocalConfig config = new TextLocalConfig();
        config.setApiKey(TestConfigReader.getApiKey());
        config.setPreferGetMethodOverPost(false);
        config.setTestMode(true);
        target = new TextlocalApiImpl(config);
    }

    @Test
    public void testTargetIsNotNull() {
        assertNotNull(target);
    }

    @Test
    public void createTargetWithConfig() throws TextlocalException {
        TextLocalConfig config = new TextLocalConfig();
        config.setApiKey(TestConfigReader.getApiKey());
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

    @Test
    public void sendMessage3Params() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
        numbers.add(TestConfigReader.getMobileNumber());
        target.sendMessage("Test Content", numbers, null);
    }

    @Test(expected = TextlocalException.class)
    public void sendMessageInvalidMessageContent() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
        numbers.add(TestConfigReader.getMobileNumber());
        target.sendMessage(null, numbers, null);
    }

    @Test(expected = TextlocalException.class)
    public void sendMessageInvalidMessageContentTooLong() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
        numbers.add(TestConfigReader.getMobileNumber());
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nec magna quis nisi dictum cursus " +
                "ut vitae arcu. Maecenas malesuada lorem eu ultrices iaculis. Cras lobortis mauris sed consequat feugiat. " +
                "Nulla facilisi. Fusce mattis lacus lectus, vitae aliquet enim lobortis a. Cras sagittis orci ac ipsum vehicula" +
                " ornare. Suspendisse eleifend magna et ligula fringilla dictum. Maecenas blandit malesuada mauris, ut aliquet " +
                "diam efficitur eget. Sed efficitur mi eget pellentesque malesuada. Aenean feugiat nec lectus quis suscipit." +
                " Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam porta, turpis eu pretium condimentum, " +
                "nunc nibh cursus massa, eu pretium odio tellus vel turpis. In egestas libero sit amet risus imperdiet, " +
                "placerat tincidunt arcu porta. Phasellus rutrum tristique diam nec varius. Orci varius natoque penatibus " +
                "et magnis dis parturient montes, nascetur ridiculus mus. Ut dignissim, ex in placerat ultrices, lacus " +
                "felis fermentum nisl, eu tempor libero sem quis enim.";
        target.sendMessage(message, numbers, null);
    }

    @Test(expected = TextlocalException.class)
    public void sendMessageInvalidNumber() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
        target.sendMessage("message", numbers, null);
    }

    @Test(expected = TextlocalException.class)
    public void sendMessageInvalidNumberTooMany() throws UnsupportedEncodingException, TextlocalException {
        List<String> numbers = new LinkedList<String>();
        for (int i = 0; i < 10001; i++) {
            numbers.add("123");
        }
        target.sendMessage("message", numbers, null);
    }

    @Test
    public void sendMessageUsingGetMethod() throws TextlocalException, UnsupportedEncodingException {
        TextLocalConfig config = new TextLocalConfig();
        config.setApiKey(TestConfigReader.getApiKey());
        config.setPreferGetMethodOverPost(true);
        config.setTestMode(true);
        target = new TextlocalApiImpl(config);
        List<String> numbers = new LinkedList<String>();
        numbers.add(TestConfigReader.getMobileNumber());
        target.sendMessage("Test Content", numbers, null);
    }

    @After
    public void tearDown() {
        target = null;
    }
}
