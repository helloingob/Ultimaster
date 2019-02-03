package de.fhl.ultimaster.api.v1.printer.validate_header;

import java.io.File;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import de.fhl.ultimaster.api.v1.objects.json.ValidateHeader;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterValidateHeaderPost {

    /** Check validation of file.
     * @param printer Connection information of the printer
     * @param file File that needs to be printed (.gcode, .gcode.gz)
     * @return List of {@link ValidateHeader} */
    public static List<ValidateHeader> post(Printer printer, File file) {
        HttpPost request = new HttpPost(printer.getUrl() + "/printer/validate_header");
        addParameter(request, file);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterValidateHeaderPostResponseParser.parse(response);
    }

    private static void addParameter(HttpPost request, File file) {
        //@formatter:off
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                                                                        .addPart("file", new FileBody(file));
        //@formatter:on
        HttpEntity multiPartEntity = builder.build();
        request.setEntity(multiPartEntity);
    }

}
