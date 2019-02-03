package de.fhl.ultimaster.api.v1.auth.check.id;

import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import de.fhl.ultimaster.utils.Settings;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.pmw.tinylog.Logger;

public class AuthCheckIdGetResponseParser {

    public static AuthorizationStatus parse(HttpResponse response) {
        if (response != null) {
            HttpEntity entity = response.getEntity();
            String body = ResponseExtractor.getBody(response);
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), entity.getContentType().getValue(), body));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && entity.getContentType().getValue().equals(Settings.Connection.CONTENT_TYPE_JSON)) {
                JSONObject jsonObject = new JSONObject(body);
                switch (jsonObject.getString("message")) {
                    case "authorized":
                        return AuthorizationStatus.AUTHORIZED;
                    case "unauthorized":
                        return AuthorizationStatus.UNAUTHORIZED;
                    case "unknown":
                        return AuthorizationStatus.UNKNOWN;
                    default:
                        break;
                }
            }
        }
        return null;
    }

}
