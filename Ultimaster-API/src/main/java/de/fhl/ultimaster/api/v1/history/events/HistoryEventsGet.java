package de.fhl.ultimaster.api.v1.history.events;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import de.fhl.ultimaster.api.v1.objects.json.Event;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class HistoryEventsGet {

    /** Get all events that happened on this printer.
     * @param printer Connection information of the printer
     * @param offset *OPTIONAL* Allow an offset parameter to specify the start in the history to get events from. Defaults to 0
     * @param count *OPTIONAL* Allow a count parameter to specify the number of events to get from the log. Defaults to 50
     * @param typeId *OPTIONAL* Allows the user to filter events by type 
     * @return List of {@link Event} */
    public static List<Event> get(Printer printer, Double offset, Double count, Double typeId) {
        HttpGet request = new HttpGet(printer.getUrl() + "/history/events" + getParameter(offset, count, typeId));
        HttpResponse response = RestConnection.execute(printer, request);
        return HistoryEventsGetResponseParser.parse(response);
    }

    private static String getParameter(Double offset, Double count, Double typeId) {
        List<NameValuePair> nameValuePairs = new LinkedList<>();
        if (offset != null) {
            nameValuePairs.add(new BasicNameValuePair("offset", String.valueOf(offset)));
        }
        if (count != null) {
            nameValuePairs.add(new BasicNameValuePair("count", String.valueOf(count)));
        }
        if (typeId != null) {
            nameValuePairs.add(new BasicNameValuePair("type_id", String.valueOf(typeId)));
        }
        return "?" + URLEncodedUtils.format(nameValuePairs, StandardCharsets.UTF_8);
    }

}
