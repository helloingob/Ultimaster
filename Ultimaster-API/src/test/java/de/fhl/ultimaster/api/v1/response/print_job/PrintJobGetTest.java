package de.fhl.ultimaster.api.v1.response.print_job;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.PrintJob;
import de.fhl.ultimaster.api.v1.print_job.PrintJobGetResponseParser;
import de.fhl.ultimaster.api.v1.print_job.PrintJobStatus;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobGetTest {

    @Test
    public void testPrintJobGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/print_job/PrintJobGet.json");
        PrintJob printJob = PrintJobGetResponseParser.parse(mockedHttpResponse);
        Assert.assertEquals(printJob.getState(), PrintJobStatus.NONE);
    }

    @Test
    public void testPrintJobGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/print_job/PrintJobGetLive.json");
        PrintJob printJob = PrintJobGetResponseParser.parse(mockedHttpResponse);
        Assert.assertEquals(printJob.getState(), PrintJobStatus.PRINTING);
    }

}
