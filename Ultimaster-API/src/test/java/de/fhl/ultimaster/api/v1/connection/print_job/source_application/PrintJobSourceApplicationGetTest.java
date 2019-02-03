package de.fhl.ultimaster.api.v1.connection.print_job.source_application;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.source_application.PrintJobSourceApplicationGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobSourceApplicationGetTest {

    @Test
    public void testPrintJobSourceApplicationGet() {
        Assert.assertNotNull(PrintJobSourceApplicationGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
