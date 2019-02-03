package de.fhl.ultimaster.api.v1.materials;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.xml.FdmMaterial;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class MaterialsGet {

    /** Returns all materials known by the printer.
     * @param printer Connection information of the printer
     * @return All known material XML files, one string for each material */
    public static List<String> get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/materials");
        HttpResponse response = RestConnection.execute(printer, request);
        return MaterialsGetResponseParser.parse(response);
    }

    /** Returns all materials known by the printer.
     * @param printer Connection information of the printer
     * @return {@link FdmMaterial}  */
    public static List<FdmMaterial> getSerialized(Printer printer) {
        List<FdmMaterial> fdmMaterials = new ArrayList<>();
        for (String material : get(printer)) {
            FdmMaterial fdmMaterial = XmlParser.deserialize(material);
            if (fdmMaterial != null) {
                fdmMaterials.add(fdmMaterial);
            }
        }
        return fdmMaterials;
    }

}
