package de.fhl.ultimaster.api.v1.response.auth.verify;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.auth.verify.AuthVerifyGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class AuthVerifyGetTest {

    @Test
    public void testAuthVerifyGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/auth/verify/AuthVerifyGet.json");
        Assert.assertTrue(AuthVerifyGetResponseParser.parse(mockedHttpResponse));
    }

}
