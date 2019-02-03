package de.fhl.ultimaster.api.v1.materials.material_guid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class MaterialsMaterialGuidGet {

    /** Get material with given GUID.
     * @param printer Connection information of the printer
     * @param materialGuid GUID of material to delete
     * @return The material */
    public static String get(Printer printer, String materialGuid) {
        HttpGet request = new HttpGet(printer.getUrl() + "/materials/" + materialGuid + "/");
        HttpResponse response = RestConnection.execute(printer, request);
        return MaterialsMaterialGuidGetResponseParser.parse(response);
    }

}
