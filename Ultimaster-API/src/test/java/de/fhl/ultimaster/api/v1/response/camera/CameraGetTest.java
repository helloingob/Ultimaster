package de.fhl.ultimaster.api.v1.response.camera;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.camera.CameraGetResponseParser;
import de.fhl.ultimaster.api.v1.objects.json.Camera;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class CameraGetTest {

    @Test
    public void testCameraGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/camera/CameraGet.json");
        Camera feed = CameraGetResponseParser.parse(mockedHttpResponse);
        Assert.assertEquals(feed.getFeed(), "http://localhost:8080/?action=stream");
    }

}
