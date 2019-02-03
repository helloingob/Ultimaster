package de.fhl.ultimaster.api.v1.connection.print_job.time_total;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.time_total.PrintJobTimeTotalGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobTimeTotalGetTest {

    @Test
    public void testPrintJobTimeTotalGet() {
        Assert.assertNotNull(PrintJobTimeTotalGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
