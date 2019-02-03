package de.fhl.ultimaster.api.v1.response.print_job.state;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.state.PrintJobStatePutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobStatePutTest {

    @Test
    public void testPrintJobStatePutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(PrintJobStatePutResponseParser.parse(mockedHttpResponse));
    }
}
