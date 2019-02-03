package de.fhl.ultimaster.api.v1.response.print_job.source_user;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.source_user.PrintJobSourceUserGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobSourceUserGetTest {

    @Test
    public void testPrintJobSourceUserGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(PrintJobSourceUserGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
