package de.fhl.ultimaster.api.v1.system.hardware.revision;

import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import de.fhl.ultimaster.utils.Settings;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.pmw.tinylog.Logger;

public class SystemHardwareRevisionGetResponseParser {

    public static Integer parse(HttpResponse response) {
        if (response != null) {
            HttpEntity entity = response.getEntity();
            String body = ResponseExtractor.getBody(response);
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), entity.getContentType().getValue(), body));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && entity.getContentType().getValue().equals(Settings.Connection.CONTENT_TYPE_JSON)) {
                return Integer.parseInt(body);
            }
        }
        return null;
    }

}
