package com.shailahir.apps.textlocal.api.constants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TextlocalConstantsTests {

    @Test
    public void testErrorEnumInvalidConfig() {
        assertEquals(60, TextlocalConstants.Errors.INVALID_CONFIG.getErrorCode());
        assertEquals("Textlocal Config is not valid", TextlocalConstants.Errors.INVALID_CONFIG.getErrorMessage());
    }
}
