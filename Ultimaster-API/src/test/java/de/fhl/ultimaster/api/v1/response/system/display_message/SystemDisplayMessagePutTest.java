package de.fhl.ultimaster.api.v1.response.system.display_message;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.display_message.SystemDisplayMessagePutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemDisplayMessagePutTest {

    @Test
    public void testAuthRequestResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithNoResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(SystemDisplayMessagePutResponseParser.parse(mockedHttpResponse));
    }

}
