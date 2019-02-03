package de.fhl.ultimaster.api.v1.connection.system.type;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.type.SystemTypeGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemTypeGetTest {

    @Test
    public void testSystemTypeGet() {
        Assert.assertNotNull(SystemTypeGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
