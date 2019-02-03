package de.fhl.ultimaster.api.v1.system.language;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class SystemLanguageGet {

    /** Get the language of the system (for WIFI!!!).
     * @param printer Connection information of the printer
     * @return Language of the system */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/system/language");
        HttpResponse response = RestConnection.execute(printer, request);
        return SystemLanguageGetResponseParser.parse(response);
    }

}
