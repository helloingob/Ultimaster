package de.fhl.ultimaster.api.v1.connection.print_job.state;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.state.PrintJobStateGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobStateGetTest {

    @Test
    public void testPrintJobStateGet() {
        Assert.assertNotNull(PrintJobStateGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
