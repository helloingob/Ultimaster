package de.fhl.ultimaster.api.v1.connection.print_job;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import de.fhl.ultimaster.api.v1.print_job.PrintJobPost;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class PrintJobPutTest {

    @Test
    public void testPrintJobGet() {
        Assert.assertNotNull(PrintJobPost.post(TestPrinter.getInstance().getPrinter(), "UM3_Ultimaster_Test", new File("e:\\UM3_CactusPot.gcode.gz")));
    }

}
