package de.fhl.ultimaster.api.v1.response.camera.index.snapshot;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.camera.index.snapshot.CameraIndexSnapshotGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class CameraIndexSnapshotGetTest {

    @Test
    public void testCameraIndexSnapshotGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithLocationHeader("url", HttpStatus.SC_MOVED_TEMPORARILY);
        Assert.assertTrue(CameraIndexSnapshotGetResponseParser.parse(mockedHttpResponse).equals("url"));
    }

}
