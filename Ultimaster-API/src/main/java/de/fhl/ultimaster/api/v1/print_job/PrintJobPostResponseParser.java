package de.fhl.ultimaster.api.v1.print_job;

import com.google.gson.Gson;
import de.fhl.ultimaster.api.v1.objects.json.PrintJobAccepted;
import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import de.fhl.ultimaster.utils.Settings;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.pmw.tinylog.Logger;

public class PrintJobPostResponseParser {

    public static PrintJobAccepted parse(HttpResponse response) {
        if (response != null) {
            HttpEntity entity = response.getEntity();
            String body = ResponseExtractor.getBody(response);
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), entity.getContentType().getValue(), body));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED && entity.getContentType().getValue().equals(Settings.Connection.CONTENT_TYPE_JSON)) {
                return new Gson().fromJson(body, PrintJobAccepted.class);
            }
        }
        return null;
    }

}
