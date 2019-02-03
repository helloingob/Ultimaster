package de.fhl.ultimaster.api.v1.connection.print_job.source_user;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.source_user.PrintJobSourceUserGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobSourceUserGetTest {

    @Test
    public void testPrintJobSourceUserGet() {
        Assert.assertNotNull(PrintJobSourceUserGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
