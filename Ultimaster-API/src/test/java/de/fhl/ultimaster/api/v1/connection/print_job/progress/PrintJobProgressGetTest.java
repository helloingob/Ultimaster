package de.fhl.ultimaster.api.v1.connection.print_job.progress;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.progress.PrintJobProgressGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobProgressGetTest {

    @Test
    public void testPrintJobProgressGet() {
        Assert.assertNotNull(PrintJobProgressGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
