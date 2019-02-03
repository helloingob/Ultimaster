package de.fhl.ultimaster.api.v1.response.auth.request;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.auth.request.AuthRequestPostResponseParser;
import de.fhl.ultimaster.api.v1.objects.json.Credential;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class AuthRequestPostTest {

    @Test
    public void testAuthRequestResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/auth/request/AuthRequestPost.json");
        Credential credential = AuthRequestPostResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(credential.getId().equals("string"));
        Assert.assertTrue(credential.getKey().equals("string"));
    }

}
