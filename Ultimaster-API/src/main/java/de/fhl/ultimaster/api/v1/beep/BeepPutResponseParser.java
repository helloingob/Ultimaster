package de.fhl.ultimaster.api.v1.beep;

import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.pmw.tinylog.Logger;

public class BeepPutResponseParser {

    public static boolean parse(HttpResponse response) {
        if (response != null) {
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), ResponseExtractor.getContentType(response), ResponseExtractor.getBody(response)));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NO_CONTENT) {
                return true;
            } else {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_BAD_REQUEST) {
                    Logger.error("Unable to beep due to missing parameters");
                }
            }
        }
        return false;
    }

}
