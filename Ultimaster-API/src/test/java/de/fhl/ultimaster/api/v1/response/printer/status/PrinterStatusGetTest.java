package de.fhl.ultimaster.api.v1.response.printer.status;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.printer.status.PrinterStatus;
import de.fhl.ultimaster.api.v1.printer.status.PrinterStatusGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterStatusGetTest {

    @Test
    public void testPrinterStatusGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithCustomStringResponse("idle", HttpStatus.SC_OK);
        Assert.assertTrue(PrinterStatusGetResponseParser.parse(mockedHttpResponse).equals(PrinterStatus.IDLE));
    }

}
