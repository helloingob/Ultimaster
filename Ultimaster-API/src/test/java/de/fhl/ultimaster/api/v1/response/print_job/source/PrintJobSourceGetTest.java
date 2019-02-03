package de.fhl.ultimaster.api.v1.response.print_job.source;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.print_job.source.PrintJobSource;
import de.fhl.ultimaster.api.v1.print_job.source.PrintJobSourceGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobSourceGetTest {

    @Test
    public void testPrintJobSourceGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithCustomStringResponse("WEB_API", HttpStatus.SC_OK);
        Assert.assertTrue(PrintJobSourceGetResponseParser.parse(mockedHttpResponse).equals(PrintJobSource.WEB_API));
    }

}
