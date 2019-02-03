package de.fhl.ultimaster.api.v1.connection.system.log;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.log.SystemLogGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemLogGetTest {

    @Test
    public void testSystemLogGetCurrent() {
        Assert.assertNotNull(SystemLogGet.getFromCurrentBootSession(TestPrinter.getInstance().getPrinter(), null));
    }

    @Test
    public void testSystemLogGetPrevious() {
        Assert.assertNotNull(SystemLogGet.getFromPreviousBootSession(TestPrinter.getInstance().getPrinter(), null));
    }

}
