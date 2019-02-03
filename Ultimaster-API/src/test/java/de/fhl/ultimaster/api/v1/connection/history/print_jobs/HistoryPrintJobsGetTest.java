package de.fhl.ultimaster.api.v1.connection.history.print_jobs;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.history.print_jobs.HistoryPrintJobsGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class HistoryPrintJobsGetTest {

    @Test
    public void testHistoryPrintJobsGet() {
        Assert.assertNotNull(HistoryPrintJobsGet.get(TestPrinter.getInstance().getPrinter(), null, null));
    }

}
