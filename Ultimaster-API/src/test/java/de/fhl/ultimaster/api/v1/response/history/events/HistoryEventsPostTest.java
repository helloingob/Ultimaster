package de.fhl.ultimaster.api.v1.response.history.events;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.history.events.HistoryEventsPostResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class HistoryEventsPostTest {

    @Test
    public void testHistoryEventsPostResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(HistoryEventsPostResponseParser.parse(mockedHttpResponse));
    }

}
