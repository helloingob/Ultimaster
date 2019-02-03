package de.fhl.ultimaster.api.v1.camera.index.snapshot;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class CameraIndexSnapshotGet {

    /** Get a redirection to the camera snapshot.
     * @param printer Connection information of the printer
     * @param index Index of the camera to get the snapshot from.  
     * @return Url to the camera snapshot */
    public static String get(Printer printer, Double index) {
        HttpGet request = new HttpGet(printer.getUrl() +"/camera/" + index + "/stream");
        HttpResponse response = RestConnection.execute(printer, request);
        return CameraIndexSnapshotGetResponseParser.parse(response);
    }

}
