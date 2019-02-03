package de.fhl.ultimaster.api.v1.response.print_job.state;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.state.PrintJobStateGetResponseParser;
import de.fhl.ultimaster.api.v1.print_job.state.PrinterState;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobStateGetTest {

    @Test
    public void testPrintJobStateGetTestResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithCustomStringResponse("print", HttpStatus.SC_OK);
        Assert.assertTrue(PrintJobStateGetResponseParser.parse(mockedHttpResponse).equals(PrinterState.PRINT));
    }

}
