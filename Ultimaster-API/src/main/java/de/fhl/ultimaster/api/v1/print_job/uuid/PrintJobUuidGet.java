package de.fhl.ultimaster.api.v1.print_job.uuid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobUuidGet {

    /** Unique identifier of this print job. In a UUID4 format.
     * @param printer Connection information of the printer
     * @return UUID4 */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/print_job/uuid");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobUuidGetResponseParser.parse(response);
    }

}
