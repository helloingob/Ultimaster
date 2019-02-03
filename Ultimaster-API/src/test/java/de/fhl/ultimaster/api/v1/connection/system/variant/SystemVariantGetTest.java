package de.fhl.ultimaster.api.v1.connection.system.variant;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.variant.SystemVariantGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemVariantGetTest {

    @Test
    public void testSystemVariantGet() {
        Assert.assertNotNull(SystemVariantGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
