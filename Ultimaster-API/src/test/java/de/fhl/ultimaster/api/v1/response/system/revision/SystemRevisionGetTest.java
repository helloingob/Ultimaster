package de.fhl.ultimaster.api.v1.response.system.revision;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.hardware.revision.SystemHardwareRevisionGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemRevisionGetTest {

    @Test
    public void testSystemRevisionGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithIntegerResponse(HttpStatus.SC_OK);
        Assert.assertTrue(SystemHardwareRevisionGetResponseParser.parse(mockedHttpResponse) == 1);
    }

}
