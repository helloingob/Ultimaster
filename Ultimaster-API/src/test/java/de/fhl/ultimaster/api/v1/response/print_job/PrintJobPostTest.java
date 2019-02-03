package de.fhl.ultimaster.api.v1.response.print_job;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.PrintJobAccepted;
import de.fhl.ultimaster.api.v1.print_job.PrintJobPostResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrintJobPostTest {

    @Test
    public void testPrintJobPostResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/print_job/PrintJobPost.json", 201);
        PrintJobAccepted printJob = PrintJobPostResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(printJob.getMessage().equals("string"));
        Assert.assertTrue(printJob.getUuid().equals("string"));
    }

    @Test
    public void testPrintJobPostLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/print_job/PrintJobPostLive.json", 201);
        PrintJobAccepted printJob = PrintJobPostResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(printJob.getMessage().equals("Print job started"));
        Assert.assertTrue(printJob.getUuid().equals("71556eaf-d101-416c-b600-9daff88589e3"));
    }

}
