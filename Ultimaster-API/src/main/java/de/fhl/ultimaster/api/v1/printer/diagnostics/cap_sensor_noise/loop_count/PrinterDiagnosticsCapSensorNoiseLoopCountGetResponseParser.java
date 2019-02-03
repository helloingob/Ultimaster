package de.fhl.ultimaster.api.v1.printer.diagnostics.cap_sensor_noise.loop_count;

import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.pmw.tinylog.Logger;

public class PrinterDiagnosticsCapSensorNoiseLoopCountGetResponseParser {

    public static String parse(HttpResponse response) {
        if (response != null) {
            HttpEntity entity = response.getEntity();
            String body = ResponseExtractor.getBody(response);
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), entity.getContentType().getValue(), body));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return body;
            } else {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_BAD_REQUEST) {
                    Logger.error("Timeout occured (Taking too long to get the data or the printer is already busy!)");
                }
            }
        }
        return null;
    }

}
