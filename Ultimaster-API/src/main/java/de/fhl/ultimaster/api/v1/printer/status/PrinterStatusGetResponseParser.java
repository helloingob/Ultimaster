package de.fhl.ultimaster.api.v1.printer.status;

import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import de.fhl.ultimaster.utils.Settings;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.pmw.tinylog.Logger;

public class PrinterStatusGetResponseParser {

    public static PrinterStatus parse(HttpResponse response) {
        if (response != null) {
            HttpEntity entity = response.getEntity();
            String body = ResponseExtractor.getBody(response);
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), entity.getContentType().getValue(), body));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && entity.getContentType().getValue().equals(Settings.Connection.CONTENT_TYPE_JSON)) {
                switch (body) {
                    case "idle":
                        return PrinterStatus.IDLE;
                    case "printing":
                        return PrinterStatus.PRINTING;
                    case "error":
                        return PrinterStatus.ERROR;
                    case "maintenance":
                        return PrinterStatus.MAINTENANCE;
                    case "booting":
                        return PrinterStatus.BOOTING;
                    default:
                        break;
                }
            }
        }
        return null;
    }

}
