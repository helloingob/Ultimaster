package de.fhl.ultimaster.api.v1.response.system;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.System;
import de.fhl.ultimaster.api.v1.system.SystemGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemGetTest {

    @Test
    @Ignore
    //API differs from live printer!
    public void testSystemGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/system/SystemGet.json");
        System system = SystemGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(system.getMemory().getTotal() == 0);
        Assert.assertTrue(system.getHardware().getRevision() == 0);
        //Assert.assertEquals(system.getVersion(), "string");
    }

    @Test
    public void testSystemGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/system/SystemGetLive.json");
        System system = SystemGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(system.getMemory().getTotal() == 1054154752);
        Assert.assertTrue(system.getHardware().getTypeid() == 9066);
        Assert.assertEquals(system.getCountry(), "DE");
        Assert.assertEquals(system.getPlatform(), "Linux-4.9.26-ultimaker-00898-g57911870dfd9-armv7l-with-debian-8.1");
        Assert.assertTrue(system.getHardware().getRevision() == 0);
        Assert.assertEquals(system.getTime().getUtc(), "1527228449.014232");
    }

}
