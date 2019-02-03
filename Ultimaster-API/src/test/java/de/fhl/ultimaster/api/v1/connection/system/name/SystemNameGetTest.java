package de.fhl.ultimaster.api.v1.connection.system.name;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.name.SystemNameGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemNameGetTest {

    @Test
    public void testSystemNameGet() {
        Assert.assertNotNull(SystemNameGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
