package de.fhl.ultimaster.api.v1.response.print_job.time_total;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.time_total.PrintJobTimeTotalGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobTimeTotalGetTest {

    @Test
    public void testPrintJobTimeTotalGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithIntegerResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrintJobTimeTotalGetResponseParser.parse(mockedHttpResponse) == 1);
    }
}
