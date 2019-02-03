package de.fhl.ultimaster.api.v1.connection.system.guid;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.guid.SystemGuidGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemGuidGetTest {

    @Test
    public void testSystemGuidGet() {
        Assert.assertNotNull(SystemGuidGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
