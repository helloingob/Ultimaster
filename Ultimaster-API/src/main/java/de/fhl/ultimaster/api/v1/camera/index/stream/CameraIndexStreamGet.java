package de.fhl.ultimaster.api.v1.camera.index.stream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class CameraIndexStreamGet {

    /** Get a redirection to the camera live feed.
     * @param printer Connection information of the printer
     * @param index index of the camera to get the feed from. 
     * @return Url to the camera stream */
    public static String get(Printer printer, Double index) {
        HttpGet request = new HttpGet(printer.getUrl() +"/camera/" + index + "/stream");
        HttpResponse response = RestConnection.execute(printer, request);
        return CameraIndexStreamGetResponseParser.parse(response);
    }

}
