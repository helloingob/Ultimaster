package de.fhl.ultimaster.api.v1.response.beep;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.beep.BeepPutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class BeepPutTest {

    @Test
    public void testBeepPutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithNoResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(BeepPutResponseParser.parse(mockedHttpResponse));
    }

}
