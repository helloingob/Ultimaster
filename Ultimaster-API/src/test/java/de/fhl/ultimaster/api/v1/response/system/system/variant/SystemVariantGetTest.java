package de.fhl.ultimaster.api.v1.response.system.system.variant;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.variant.SystemVariantGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemVariantGetTest {

    @Test
    public void testSystemVariantGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(SystemVariantGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
