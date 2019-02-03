package de.fhl.ultimaster.api.v1.auth.check.id;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class AuthCheckIdGet {

    /** Check if the given ID is authorized for printer access.
     * @param printer Connection information of the printer
     * @return {@link AuthorizationStatus} */
    public static AuthorizationStatus get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/auth/check/" + printer.getPrinterId());
        HttpResponse response = RestConnection.execute(printer, request);
        return AuthCheckIdGetResponseParser.parse(response);
    }

}
