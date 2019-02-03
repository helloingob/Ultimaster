package de.fhl.ultimaster.api.v1.auth.verify;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class AuthVerifyGet {

    /** This API call always does authentication checking for digest authentication. 
     * @param printer Connection information of the printer
     * @return Success? */
    public static boolean get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() +"/auth/verify");
        HttpResponse response = RestConnection.execute(printer, request);
        return AuthVerifyGetResponseParser.parse(response);
    }

}
