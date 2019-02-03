package de.fhl.ultimaster.api.v1.response.system.country;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.country.SystemCountryGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemCountryGetTest {

    @Test
    public void testSystemCountryGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(SystemCountryGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
