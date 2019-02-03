package de.fhl.ultimaster.api.v1.response.system.guid;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.guid.SystemGuidGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemGuidGetTest {

    @Test
    public void testSystemGuidGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(SystemGuidGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
