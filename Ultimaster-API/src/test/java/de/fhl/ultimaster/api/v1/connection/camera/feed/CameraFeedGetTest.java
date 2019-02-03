package de.fhl.ultimaster.api.v1.connection.camera.feed;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.camera.feed.CameraFeedGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class CameraFeedGetTest {

    @Test
    public void testCameraFeedGet() {
        Assert.assertNotNull(CameraFeedGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
