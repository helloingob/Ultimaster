package de.fhl.ultimaster.api.v1.system.name;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemNamePut {

    /**
     * Sets the system name.
     * 
     * @param printer
     *            Connection information of the printer
     * @param name
     *            Target name of machine
     * @return Success?
     */
    public static boolean put(Printer printer, String name) {
        HttpPut request = new HttpPut(printer.getUrl() + "/system/name");
        addParameter(request, name);
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemNamePutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, String name) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity("\"" + name + "\""));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
