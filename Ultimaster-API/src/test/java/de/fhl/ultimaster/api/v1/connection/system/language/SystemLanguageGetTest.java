package de.fhl.ultimaster.api.v1.connection.system.language;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.language.SystemLanguageGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class SystemLanguageGetTest {

    @Test
    public void testSystemLanguageGet() {
        Assert.assertNotNull(SystemLanguageGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
