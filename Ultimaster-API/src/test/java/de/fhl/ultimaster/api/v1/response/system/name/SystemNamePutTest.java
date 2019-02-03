package de.fhl.ultimaster.api.v1.response.system.name;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.name.SystemNamePutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemNamePutTest {

    @Test
    public void testSystemNamePutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithNoResponse(HttpStatus.SC_OK);
        Assert.assertTrue(SystemNamePutResponseParser.parse(mockedHttpResponse));
    }

}
