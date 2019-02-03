package de.fhl.ultimaster.api.v1.response.print_job.reprint_original_uuid;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.reprint_original_uuid.PrintJobReprintOriginalUuidGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobReprintOriginalUuidGetTest {

    @Test
    public void testPrintJobReprintOriginalUuidGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrintJobReprintOriginalUuidGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
