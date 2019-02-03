package de.fhl.ultimaster.api.v1.connection.system.hardware.revision;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.hardware.revision.SystemHardwareRevisionGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemHardwareRevisionGetTest {

    @Test
    public void testSystemHardwareRevisionGet() {
        Assert.assertNotNull(SystemHardwareRevisionGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
