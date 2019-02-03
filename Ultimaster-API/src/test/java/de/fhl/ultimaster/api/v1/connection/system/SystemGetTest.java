package de.fhl.ultimaster.api.v1.connection.system;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.SystemGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemGetTest {

    @Test
    public void testSystemGet() {
        Assert.assertNotNull(SystemGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
