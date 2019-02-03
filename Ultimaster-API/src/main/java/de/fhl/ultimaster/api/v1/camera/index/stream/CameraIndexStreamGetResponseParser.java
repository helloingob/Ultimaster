package de.fhl.ultimaster.api.v1.camera.index.stream;

import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.pmw.tinylog.Logger;

public class CameraIndexStreamGetResponseParser {

    public static String parse(HttpResponse response) {
        if (response != null) {
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), ResponseExtractor.getContentType(response), ResponseExtractor.getBody(response)));
            String url = response.getFirstHeader("location").getValue();
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
                return url;
            } else {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
                    Logger.error("Camera with this index is not available in the system.");
                }
            }
        }
        return null;
    }

}
