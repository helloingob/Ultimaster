package de.fhl.ultimaster.api.v1.connection.print_job.reprint_original_uuid;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.reprint_original_uuid.PrintJobReprintOriginalUuidGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobReprintOriginalUuidGetTest {

    @Test
    public void testPrintJobReprintOriginalUuidGet() {
        Assert.assertNotNull(PrintJobReprintOriginalUuidGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
