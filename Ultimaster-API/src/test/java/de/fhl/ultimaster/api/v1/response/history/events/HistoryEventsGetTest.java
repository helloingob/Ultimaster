package de.fhl.ultimaster.api.v1.response.history.events;

import java.util.List;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.history.events.HistoryEventsGetResponseParser;
import de.fhl.ultimaster.api.v1.objects.json.Event;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class HistoryEventsGetTest {

    @Test
    public void testHistoryEventsGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/history/events/HistoryEventsGet.json");
        List<Event> events = HistoryEventsGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(events.size() > 0);
        Event event = events.get(0);
        Assert.assertTrue(event.getTime().equals("2018-04-06T05:42:06.510Z"));
        Assert.assertTrue(event.getTypeId() == 0);
        Assert.assertTrue(event.getMessage().equals("string"));
        Assert.assertTrue(event.getParameters().size() > 0);
        String parameter = event.getParameters().get(0);
        Assert.assertTrue(parameter.equals("string"));
    }
    
    @Test
    public void testHistoryEventsGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/history/events/HistoryEventsGetLive.json");
        List<Event> events = HistoryEventsGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(events.size() > 0);
        Event event = events.get(0);
        Assert.assertTrue(event.getTime().equals("2018-05-25T06:31:52"));
        Assert.assertTrue(event.getTypeId() == 1048576);
        Assert.assertTrue(event.getMessage().equals("API Authentication added for application: Ultimaster user: Ultimaster API with id: fc39faebcb1ccc92955f25c720a8ef11"));
        Assert.assertTrue(event.getParameters().size() > 0);
        String parameter = event.getParameters().get(0);
        Assert.assertTrue(parameter.equals("fc39faebcb1ccc92955f25c720a8ef11"));
    }

}
