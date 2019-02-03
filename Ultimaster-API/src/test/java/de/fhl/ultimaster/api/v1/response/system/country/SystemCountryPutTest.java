package de.fhl.ultimaster.api.v1.response.system.country;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.country.SystemCountryPutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemCountryPutTest {

    @Test
    public void testAuthRequestResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithNoResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(SystemCountryPutResponseParser.parse(mockedHttpResponse));
    }

}
