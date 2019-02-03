package de.fhl.ultimaster.api.v1.response.print_job.progress;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.progress.PrintJobProgressGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobProgressGetTest {

    @Test
    public void testPrintJobProgressGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithDoubleResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrintJobProgressGetResponseParser.parse(mockedHttpResponse) == 1.0);
    }
}
