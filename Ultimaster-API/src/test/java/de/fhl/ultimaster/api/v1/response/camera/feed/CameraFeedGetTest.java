package de.fhl.ultimaster.api.v1.response.camera.feed;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.camera.feed.CameraFeedGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class CameraFeedGetTest {

    @Test
    public void testCameraFeedGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(CameraFeedGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
