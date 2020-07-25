package com.shailahir.apps.textlocal.api.exception;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class TextlocalExceptionTests {

    private TextlocalException target;

    @Before
    public void setup() {
        target = new TextlocalException();
    }

    @Test
    public void testTargetIsNotNull() {
        assertNotNull(target);
    }

    @Test
    public void testExceptionConstructorSetCodeAndMessage() {
        String val = "ERROR_MESSAGE";
        target = new TextlocalException(12, val);
        assertEquals(val, target.getErrorMessage());
        assertEquals(12, target.getErrorCode());
        assertEquals(val, target.getMessage());
    }


    @After
    public void tearDown() {
        target = null;
    }
}
