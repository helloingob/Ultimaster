package de.fhl.ultimaster.api.v1.connection.system.uptime;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.uptime.SystemUptimeGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemUptimeGetTest {

    @Test
    public void testSystemUptimeGet() {
        Assert.assertNotNull(SystemUptimeGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
