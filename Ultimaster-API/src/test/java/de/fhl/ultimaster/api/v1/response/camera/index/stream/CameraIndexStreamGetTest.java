package de.fhl.ultimaster.api.v1.response.camera.index.stream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.camera.index.stream.CameraIndexStreamGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class CameraIndexStreamGetTest {

    @Test
    public void testCameraIndexStreamGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithLocationHeader("url", HttpStatus.SC_MOVED_TEMPORARILY);
        Assert.assertTrue(CameraIndexStreamGetResponseParser.parse(mockedHttpResponse).equals("url"));
    }

}
