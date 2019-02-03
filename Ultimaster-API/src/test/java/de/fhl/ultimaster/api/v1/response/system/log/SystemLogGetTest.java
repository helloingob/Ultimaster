package de.fhl.ultimaster.api.v1.response.system.log;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.LogLine;
import de.fhl.ultimaster.api.v1.system.LogLineParser;
import de.fhl.ultimaster.api.v1.system.log.SystemLogGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class SystemLogGetTest {

    @Test
    public void testSystemLogGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/system/log/PrinterLogGetTest.json");
        List<String> materials = SystemLogGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(materials.get(0).equals("string"));
    }

    @Test
    public void testSystemLogGetLiveTest() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/system/log/PrinterLogGetTestLive.json");
        List<String> lines = SystemLogGetResponseParser.parse(mockedHttpResponse);
        List<LogLine> logLines = new ArrayList<>();
        for (String line : lines) {
            LogLine logLine = LogLineParser.getLogLine(line);
            logLines.add(logLine);
        }
        Assert.assertTrue(logLines.size() == 50);
    }

}
