package de.fhl.ultimaster.api.v1.materials.material_guid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class MaterialsMaterialGuidPut {

    /** Update material with given GUID.
     * @param printer Connection information of the printer
     * @param materialGuid GUID of material to update
     * @return Success? */
    public static boolean put(Printer printer, String material_guid) {
        HttpPut request = new HttpPut(printer.getUrl() + "/materials/" + material_guid + "/");
        HttpResponse response = RestConnection.execute(printer, request);
        return MaterialsMaterialGuidPutResponseParser.parse(response);
    }

}
