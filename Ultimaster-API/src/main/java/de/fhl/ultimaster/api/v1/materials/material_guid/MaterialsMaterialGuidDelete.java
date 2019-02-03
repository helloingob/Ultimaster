package de.fhl.ultimaster.api.v1.materials.material_guid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class MaterialsMaterialGuidDelete {

    /** Delete material with given GUID.
     * @param printer Connection information of the printer
     * @param materialGuid GUID of material to delete
     * @return Success? */
    public static boolean delete(Printer printer, String materialGuid) {
        HttpDelete request = new HttpDelete(printer.getUrl() + "/materials/" + materialGuid + "/");
        HttpResponse response = RestConnection.execute(printer, request);
        return MaterialsMaterialGuidDeleteResponseParser.parse(response);
    }

}
