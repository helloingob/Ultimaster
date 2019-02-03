package de.fhl.ultimaster.api.v1.connection.print_job;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.PrintJobGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobGetTest {

    @Test
    public void testPrintJobGet() {
        Assert.assertNotNull(PrintJobGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
