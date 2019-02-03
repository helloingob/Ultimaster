package de.fhl.ultimaster.api.v1.materials;

import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import de.fhl.ultimaster.api.v1.history.events.HistoryEventsPostResponseParser;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class MaterialsPost {

    /** Add material profile.
     * @param printer Connection information of the printer
     * @param file Material file (.xml) 
     * @param filename Name of the file
     * @param *OPTIONAL* signatureFile Signature file (.sig)
     * @return Success? */
    public static boolean post(Printer printer, File file, String filename, File signatureFile) {
        HttpPost request = new HttpPost(printer.getUrl() + "/materials");
        addParameter(request, file, filename, signatureFile);
        HttpResponse response = RestConnection.execute(printer, request);
        return HistoryEventsPostResponseParser.parse(response);
    }

    private static void addParameter(HttpPost request, File file, String filename, File signatureFile) {
        //@formatter:off
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                                                                        .addTextBody("filename", filename)
                                                                        .addPart("file", new FileBody(file));
        if (signatureFile != null) {
            builder.addPart("signature_file", new FileBody(signatureFile));
        }
        //@formatter:on
        HttpEntity multiPartEntity = builder.build();
        request.setEntity(multiPartEntity);
    }

}
