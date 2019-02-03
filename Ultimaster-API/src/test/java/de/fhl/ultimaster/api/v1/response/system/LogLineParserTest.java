package de.fhl.ultimaster.api.v1.response.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.LogLine;
import de.fhl.ultimaster.api.v1.system.LogLineParser;
import de.fhl.ultimaster.api.v1.utils.FileLibrary;

public class LogLineParserTest {

    @Test
    public void testLogLineParser() {
        String csv = FileLibrary.getFileContent("de/fhl/ultimaster/api/v1/response/system/LogLines.txt");
        List<String> lines = Arrays.asList(csv.split("\n"));
        List<LogLine> logLines = new ArrayList<>();
        for (String line : lines) {
            LogLine logLine = LogLineParser.getLogLine(line);
            logLines.add(logLine);
        }
        Assert.assertTrue(logLines.size() == 50);
    }

}
