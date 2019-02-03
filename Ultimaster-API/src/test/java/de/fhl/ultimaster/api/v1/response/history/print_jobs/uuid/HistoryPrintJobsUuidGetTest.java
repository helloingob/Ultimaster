package de.fhl.ultimaster.api.v1.response.history.print_jobs.uuid;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.history.print_jobs.uuid.HistoryPrintJobsUuidGetResponseParser;
import de.fhl.ultimaster.api.v1.objects.json.PrintJobHistoric;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class HistoryPrintJobsUuidGetTest {

    @Test
    public void testHistoryPrintJobsUuidGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/history/print_jobs/uuid/HistoryPrintJobsGet.json");
        PrintJobHistoric printJobHistoric = HistoryPrintJobsUuidGetResponseParser.parse(mockedHttpResponse);
        Assert.assertEquals(printJobHistoric.getResult(), "Finished");
    }

}
