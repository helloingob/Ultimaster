package de.fhl.ultimaster.api.v1.connection.auth;

import org.junit.Assert;
import org.junit.Test;

import de.fhl.ultimaster.api.v1.auth.verify.AuthVerifyGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class AuthVerifyGetTest {

    @Test
    public void testRestConnection() {
    	Assert.assertNotNull(AuthVerifyGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
