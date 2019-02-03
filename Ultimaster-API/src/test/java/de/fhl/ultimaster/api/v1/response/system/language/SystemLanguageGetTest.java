package de.fhl.ultimaster.api.v1.response.system.language;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.system.language.SystemLanguageGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemLanguageGetTest {

    @Test
    public void testSystemLanguageGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(SystemLanguageGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
