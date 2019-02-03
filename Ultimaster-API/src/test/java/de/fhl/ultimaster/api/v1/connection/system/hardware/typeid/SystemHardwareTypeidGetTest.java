package de.fhl.ultimaster.api.v1.connection.system.hardware.typeid;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.hardware.typeid.SystemHardwareTypeidGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemHardwareTypeidGetTest {

    @Test
    public void testSystemHardwareTypeidGet() {
        Assert.assertNotNull(SystemHardwareTypeidGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
