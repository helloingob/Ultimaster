package de.fhl.ultimaster.api.v1.response.print_job.uuid;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.uuid.PrintJobUuidGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobUuidGetTest {

    @Test
    public void testPrintJobUuidGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrintJobUuidGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
