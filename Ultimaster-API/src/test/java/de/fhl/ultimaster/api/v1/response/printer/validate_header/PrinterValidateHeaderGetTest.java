package de.fhl.ultimaster.api.v1.response.printer.validate_header;

import java.util.List;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.objects.json.ValidateHeader;
import de.fhl.ultimaster.api.v1.printer.validate_header.PrinterValidateHeaderPostResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class PrinterValidateHeaderGetTest {

    @Test
    public void testPrinterValidateHeaderGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/printer/validate_header/PrinterValidateHeaderPost.json");
        List<ValidateHeader> validateHeaders = PrinterValidateHeaderPostResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(validateHeaders.size() > 0);
        ValidateHeader validationMishap = validateHeaders.get(0);
        Assert.assertTrue(validationMishap.getFaultCode().equals("HEADER_NOT_PRESENT"));
        Assert.assertTrue(validationMishap.getFaultLevel().equals("WARNING"));
        Assert.assertTrue(validationMishap.getMessage().equals("string"));
        Assert.assertTrue(validationMishap.getData().equals("string"));
    }

}
