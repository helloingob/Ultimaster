package de.fhl.ultimaster.api.v1.connection.print_job.source;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.source.PrintJobSourceGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobSourceGetTest {

    @Test
    public void testPrintJobSourceGet() {
        Assert.assertNotNull(PrintJobSourceGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
