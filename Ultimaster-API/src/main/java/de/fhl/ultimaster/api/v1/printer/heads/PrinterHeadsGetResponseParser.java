package de.fhl.ultimaster.api.v1.printer.heads;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.fhl.ultimaster.api.v1.objects.json.Head;
import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import de.fhl.ultimaster.utils.Settings;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.pmw.tinylog.Logger;

public class PrinterHeadsGetResponseParser {

    public static List<Head> parse(HttpResponse response) {
        if (response != null) {
            HttpEntity entity = response.getEntity();
            String body = ResponseExtractor.getBody(response);
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), entity.getContentType().getValue(), body));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && entity.getContentType().getValue().equals(Settings.Connection.CONTENT_TYPE_JSON)) {
                return new Gson().fromJson(body, new TypeToken<List<Head>>() {}.getType());
            }
        }
        return Collections.emptyList();
    }

}
