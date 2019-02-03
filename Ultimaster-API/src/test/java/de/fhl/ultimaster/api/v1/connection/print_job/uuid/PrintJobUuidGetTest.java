package de.fhl.ultimaster.api.v1.connection.print_job.uuid;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.uuid.PrintJobUuidGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobUuidGetTest {

    @Test
    public void testPrintJobUuidGet() {
        Assert.assertNotNull(PrintJobUuidGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
