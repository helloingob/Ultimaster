package de.fhl.ultimaster.api.v1.camera;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.api.v1.objects.json.Camera;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class CameraGet {

    /** Returns camera object.
     * @param printer Connection information of the printer
     * @return {@link Camera} */
    public static Camera get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() +"/camera");
        HttpResponse response = RestConnection.execute(printer, request);
        return CameraGetResponseParser.parse(response);
    }

}
