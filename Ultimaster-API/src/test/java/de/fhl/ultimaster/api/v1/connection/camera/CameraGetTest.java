package de.fhl.ultimaster.api.v1.connection.camera;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.camera.CameraGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class CameraGetTest {

    @Test
    public void testCameraGet() {
        Assert.assertNotNull(CameraGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
