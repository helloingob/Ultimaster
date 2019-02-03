package de.fhl.ultimaster.api.v1.beep;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.message.BasicNameValuePair;
import org.pmw.tinylog.Logger;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class BeepPut {

    /** Makes the printer beep.
     * @param printer Connection information of the printer
     * @param frequency The frequency of the tone (in Hz)
     * @param duration The duration of the tone (in ms)
     * @return Success? */
    public static boolean put(Printer printer, double frequency, double duration) {
        HttpPut request = new HttpPut(printer.getUrl() + "/beep");
        addParameter(request, frequency, duration);
        HttpResponse response = RestConnection.execute(printer, request);
        return BeepPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, double frequency, double duration) {
        List<NameValuePair> nameValuePairs = new LinkedList<>();
        nameValuePairs.add(new BasicNameValuePair("frequency", String.valueOf(frequency)));
        nameValuePairs.add(new BasicNameValuePair("duration", String.valueOf(duration)));
        HttpEntity requestEntity = null;
        try {
            requestEntity = new UrlEncodedFormEntity(nameValuePairs);
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
        request.setEntity(requestEntity);
    }

}
