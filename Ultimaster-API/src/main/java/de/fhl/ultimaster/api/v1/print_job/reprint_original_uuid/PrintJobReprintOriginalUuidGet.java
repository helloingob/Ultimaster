package de.fhl.ultimaster.api.v1.print_job.reprint_original_uuid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobReprintOriginalUuidGet {

    /** Unique identifier of this print job. In a UUID4 format.
     * @param printer Connection information of the printer
     * @return UUID */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job/reprint_original_uuid");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobReprintOriginalUuidGetResponseParser.parse(response);
    }

}
