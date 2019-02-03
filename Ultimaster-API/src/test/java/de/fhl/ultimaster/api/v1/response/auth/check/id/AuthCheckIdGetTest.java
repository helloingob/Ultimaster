package de.fhl.ultimaster.api.v1.response.auth.check.id;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.auth.check.id.AuthCheckIdGetResponseParser;
import de.fhl.ultimaster.api.v1.auth.check.id.AuthorizationStatus;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class AuthCheckIdGetTest {

    @Test
    public void testAuthCheckGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/auth/check/id/AuthCheckIdGet.json");
        Assert.assertTrue(AuthCheckIdGetResponseParser.parse(mockedHttpResponse).equals(AuthorizationStatus.AUTHORIZED));
    }

}
