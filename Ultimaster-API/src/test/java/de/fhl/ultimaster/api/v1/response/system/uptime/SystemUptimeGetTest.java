package de.fhl.ultimaster.api.v1.response.system.uptime;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.uptime.SystemUptimeGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemUptimeGetTest {

    @Test
    public void testSystemUptimeGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithIntegerResponse(HttpStatus.SC_OK);
        Assert.assertTrue(SystemUptimeGetResponseParser.parse(mockedHttpResponse) == 1);
    }

}
