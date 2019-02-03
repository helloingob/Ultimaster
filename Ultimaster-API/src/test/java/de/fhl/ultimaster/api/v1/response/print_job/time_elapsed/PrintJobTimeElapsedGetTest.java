package de.fhl.ultimaster.api.v1.response.print_job.time_elapsed;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.time_elapsed.PrintJobTimeElapsedGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobTimeElapsedGetTest {

    @Test
    public void testPrintJobTimeElapsedGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithIntegerResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrintJobTimeElapsedGetResponseParser.parse(mockedHttpResponse) == 1);
    }
}
