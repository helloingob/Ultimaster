package de.fhl.ultimaster.api.v1.print_job;

import com.google.gson.Gson;
import de.fhl.ultimaster.api.v1.objects.json.PrintJob;
import de.fhl.ultimaster.utils.LogFormatter;
import de.fhl.ultimaster.utils.ResponseExtractor;
import de.fhl.ultimaster.utils.Settings;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.pmw.tinylog.Logger;

public class PrintJobGetResponseParser {

    public static PrintJob parse(HttpResponse response) {
        if (response != null) {
            HttpEntity entity = response.getEntity();
            String body = ResponseExtractor.getBody(response);
            Logger.debug(LogFormatter.format(response.getStatusLine().getStatusCode(), entity.getContentType().getValue(), body));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && entity.getContentType().getValue().equals(Settings.Connection.CONTENT_TYPE_JSON)) {
                PrintJob printJob = new Gson().fromJson(body, PrintJob.class);
                JSONObject jsonObject = new JSONObject(body);
                switch (jsonObject.getString("state")) {
                    case "printing":
                        printJob.setState(PrintJobStatus.PRINTING);
                        break;
                    case "pausing":
                        printJob.setState(PrintJobStatus.PAUSING);
                        break;
                    case "paused":
                        printJob.setState(PrintJobStatus.PAUSED);
                        break;
                    case "resuming":
                        printJob.setState(PrintJobStatus.RESUMING);
                        break;
                    case "pre_print":
                        printJob.setState(PrintJobStatus.PRE_PRINT);
                        break;
                    case "post_print":
                        printJob.setState(PrintJobStatus.POST_PRINT);
                        break;
                    case "wait_cleanup":
                        printJob.setState(PrintJobStatus.WAIT_CLEANUP);
                        break;
                    default:
                        printJob.setState(PrintJobStatus.NONE);
                }
                return printJob;
            }
        }
        return null;
    }

}
