package de.fhl.ultimaster.api.v1.connection.system.country;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.country.SystemCountryGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemCountryGetTest {

    @Test
    public void testSystemCountryGet() {
        Assert.assertNotNull(SystemCountryGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
