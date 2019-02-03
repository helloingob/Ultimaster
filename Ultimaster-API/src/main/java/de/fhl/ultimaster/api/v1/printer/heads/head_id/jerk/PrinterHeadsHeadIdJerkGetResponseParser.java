package de.fhl.ultimaster.api.v1.printer.heads.head_id.jerk;

import com.google.gson.Gson;
import de.fhl.ultimaster.api.v1.objects.json.Jerk;
import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import de.fhl.ultimaster.utils.Settings;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.pmw.tinylog.Logger;

public class PrinterHeadsHeadIdJerkGetResponseParser {

    public static Jerk parse(HttpResponse response) {
        if (response != null) {
            HttpEntity entity = response.getEntity();
            String body = ResponseExtractor.getBody(response);
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), entity.getContentType().getValue(), body));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && entity.getContentType().getValue().equals(Settings.Connection.CONTENT_TYPE_JSON)) {
                return new Gson().fromJson(body, Jerk.class);
            }
        }
        return null;
    }

}
