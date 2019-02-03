package de.fhl.ultimaster.api.v1.print_job.state;

import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.pmw.tinylog.Logger;

public class PrintJobStatePut {

    /** Queue new print job.
     * @param printer Connection information of the printer
     * @param printerState Note that only changes to abort / pause are always allowed and changing to print only when state is paused
     * @return Success? */
    public static boolean put(Printer printer, PrinterState printerState) {
        HttpPut request = new HttpPut(printer.getUrl() + "/print_job/state");
        addParameter(request, printerState);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobStatePutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, PrinterState printerState) {
        try {
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
            request.setEntity(new StringEntity("{\"target\":\"" + printerState.toString().toLowerCase() + "\"}"));
        } catch (UnsupportedEncodingException e) {
            Logger.error(e);
        }
    }

}
