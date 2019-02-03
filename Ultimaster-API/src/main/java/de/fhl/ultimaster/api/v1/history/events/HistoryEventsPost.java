package de.fhl.ultimaster.api.v1.history.events;

import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class HistoryEventsPost {

    /** Log an event.
     * @param printer Connection information of the printer
     * @param typeId The type id of the event
     * @param parameters The parameters of the event
     * @return Success? */
    public static boolean post(Printer printer, double typeId, List<String> parameters) {
        HttpPost request = new HttpPost(printer.getUrl() + "/history/events");
        addParameter(request, typeId, parameters);
        HttpResponse response = RestConnection.execute(printer, request);
        return HistoryEventsPostResponseParser.parse(response);
    }

    private static void addParameter(HttpPost request, double typeId, List<String> parameters) {
        //@formatter:off
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                                                                        .addTextBody("type_id", String.valueOf(typeId))
                                                                        .addTextBody("parameters", prepareParameters(parameters));
        //@formatter:on
        HttpEntity multiPartEntity = builder.build();
        request.setEntity(multiPartEntity);
    }

    private static String prepareParameters(List<String> parameters) {
        String result = "";
        for (String parameter : parameters) {
            result += "\"" + parameter + "\"\n";
        }
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

}
