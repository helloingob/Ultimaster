package de.fhl.ultimaster.api.v1.response.print_job.source_application;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.source_application.PrintJobSourceApplicationGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobSourceApplicationGetTest {

    @Test
    public void testPrintJobSourceApplicationGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrintJobSourceApplicationGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
