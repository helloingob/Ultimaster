package de.fhl.ultimaster.api.v1.system.name;

import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.pmw.tinylog.Logger;

public class SystemNamePutResponseParser {

    public static boolean parse(HttpResponse response) {
        if (response != null) {
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), ResponseExtractor.getContentType(response), ResponseExtractor.getBody(response)));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return true;
            } else {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_BAD_REQUEST) {
                    Logger.error("Name is not set, because an invalid name is specified");
                }
            }
        }
        return false;
    }

}
