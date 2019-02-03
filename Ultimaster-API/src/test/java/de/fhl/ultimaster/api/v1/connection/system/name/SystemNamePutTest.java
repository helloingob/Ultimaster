package de.fhl.ultimaster.api.v1.connection.system.name;

import org.junit.Assert;
import org.junit.Test;

import de.fhl.ultimaster.api.v1.system.name.SystemNameGet;
import de.fhl.ultimaster.api.v1.system.name.SystemNamePut;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemNamePutTest {

    @Test
    public void testSystemNameGet() {
		Assert.assertTrue(SystemNamePut.put(TestPrinter.getInstance().getPrinter(), "Ultimaker3"));
		Assert.assertEquals(SystemNameGet.get(TestPrinter.getInstance().getPrinter()), "Ultimaker3");
    }
}

