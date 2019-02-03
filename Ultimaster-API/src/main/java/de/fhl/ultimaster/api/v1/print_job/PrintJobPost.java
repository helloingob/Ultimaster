package de.fhl.ultimaster.api.v1.print_job;

import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import de.fhl.ultimaster.api.v1.objects.json.PrintJobAccepted;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrintJobPost {

    /** Queue new print job.
     * @param printer Connection information of the printer.
     * @param jobname Name of the print job
     * @param file File that needs to be printed (.gcode, .gcode.gz)
     * @return {@link PrintJobAccepted} */
    public static PrintJobAccepted post(Printer printer, String jobname, File file) {
        HttpPost request = new HttpPost(printer.getUrl() + "/print_job");
        addParameter(request, jobname, file);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrintJobPostResponseParser.parse(response);
    }

    private static void addParameter(HttpPost request, String jobname, File file) {
        //@formatter:off
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                                                                        .addTextBody("jobname", jobname)
                                                                        .addPart("file", new FileBody(file));
        //@formatter:on
        HttpEntity multiPartEntity = builder.build();
        request.setEntity(multiPartEntity);
    }

}
