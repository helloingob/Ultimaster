package de.fhl.ultimaster.api.v1.history.print_jobs.uuid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.PrintJobHistoric;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class HistoryPrintJobsUuidGet {

    /** Get PrintJob with the given UUID.
     * @param printer Connection information of the printer
     * @param uuid UUID of the job to get
     * @return {@link PrintJobHistoric} */
    public static PrintJobHistoric get(Printer printer, String uuid) {
        HttpGet request = new HttpGet(printer.getUrl() + "/history/print_jobs/" + uuid);
        HttpResponse response = RestConnection.execute(printer, request);
        return HistoryPrintJobsUuidGetResponseParser.parse(response);
    }

}
