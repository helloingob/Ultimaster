package de.fhl.ultimaster.api.v1.connection.print_job.time_elapsed;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.time_elapsed.PrintJobTimeElapsedGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobTimeElapsedGetTest {

    @Test
    public void testPrintJobTimeElapsedGet() {
        Assert.assertNotNull(PrintJobTimeElapsedGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
