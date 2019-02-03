package de.fhl.ultimaster.api.v1.response.system.type;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.type.SystemTypeGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemTypeGetTest {

    @Test
    public void testSystemTypeGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithCustomStringResponse("3D printer", HttpStatus.SC_OK);
        Assert.assertTrue(SystemTypeGetResponseParser.parse(mockedHttpResponse).equals("3D printer"));
    }

}
