package de.fhl.ultimaster.api.v1.response.system.name;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.name.SystemNameGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemNameGetTest {

    @Test
    public void testSystemNameGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(SystemNameGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
