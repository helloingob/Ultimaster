package de.fhl.ultimaster.api.v1.response.history.print_jobs;

import java.util.List;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.history.print_jobs.HistoryPrintJobsGetResponseParser;
import de.fhl.ultimaster.api.v1.objects.json.PrintJobHistoric;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class HistoryPrintJobsGetTest {

    @Test
    public void testHistoryPrintJobsGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/history/print_jobs/HistoryPrintJobsGet.json");
        List<PrintJobHistoric> printJobs = HistoryPrintJobsGetResponseParser.parse(mockedHttpResponse);
        Assert.assertEquals(printJobs.get(0).getResult(), "Finished");
    }
    
    @Test
    public void testHistoryPrintJobsGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/history/print_jobs/HistoryPrintJobsGetLive.json");
        List<PrintJobHistoric> printJobs = HistoryPrintJobsGetResponseParser.parse(mockedHttpResponse);
        Assert.assertEquals(printJobs.get(0).getResult(), "Finished");
        Assert.assertEquals(printJobs.get(0).getUuid(), "878690c7-2185-497a-8a42-ba05cae985f4");
        Assert.assertEquals(printJobs.get(0).getName(), "UM3_logo1303_1");
    }

}
