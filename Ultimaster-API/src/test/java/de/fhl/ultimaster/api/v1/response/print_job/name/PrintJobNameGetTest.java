package de.fhl.ultimaster.api.v1.response.print_job.name;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.name.PrintJobNameGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobNameGetTest {

    @Test
    public void testPrintJobNameGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrintJobNameGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
