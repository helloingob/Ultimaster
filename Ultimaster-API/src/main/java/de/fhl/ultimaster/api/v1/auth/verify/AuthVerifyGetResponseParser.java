package de.fhl.ultimaster.api.v1.auth.verify;

import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import de.fhl.ultimaster.utils.Settings;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.pmw.tinylog.Logger;

public class AuthVerifyGetResponseParser {

    public static boolean parse(HttpResponse response) {
        if (response != null) {
            HttpEntity entity = response.getEntity();
            String body = ResponseExtractor.getBody(response);
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), entity.getContentType().getValue(), body));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && entity.getContentType().getValue().equals(Settings.Connection.CONTENT_TYPE_JSON)) {
                JSONObject jsonObject = new JSONObject(body);
                return jsonObject.getString("message").equals("ok");
            } else {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
                    Logger.error("Not authorized. Check or request your id/key combination, and/or http digest implementation.");
                }
            }
        }
        return false;
    }

}
