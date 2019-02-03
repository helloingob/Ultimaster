package de.fhl.ultimaster.api.v1.system.display_message;

import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.pmw.tinylog.Logger;

public class SystemDisplayMessagePutResponseParser {

    public static boolean parse(HttpResponse response) {
        if (response != null) {
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), ResponseExtractor.getContentType(response), ResponseExtractor.getBody(response)));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NO_CONTENT) {
                return true;
            } else {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_BAD_REQUEST) {
                    Logger.error("No message specified.");
                } else {
                    if (response.getStatusLine().getStatusCode() == HttpStatus.SC_METHOD_NOT_ALLOWED) {
                        Logger.error("Message cannot be displayed because the printer is busy.");
                    }
                }
            }
        }
        return false;
    }

}
