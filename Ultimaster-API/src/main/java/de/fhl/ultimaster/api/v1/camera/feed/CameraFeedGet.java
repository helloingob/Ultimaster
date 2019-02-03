package de.fhl.ultimaster.api.v1.camera.feed;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class CameraFeedGet {

    /** Get a link to the camera feed, this returns an url to a camera stream.
     * @param printer Connection information of the printer
     * @return Url to a camera stream */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() +"/camera/feed");
        HttpResponse response = RestConnection.execute(printer, request);
        return CameraFeedGetResponseParser.parse(response);
    }

}
