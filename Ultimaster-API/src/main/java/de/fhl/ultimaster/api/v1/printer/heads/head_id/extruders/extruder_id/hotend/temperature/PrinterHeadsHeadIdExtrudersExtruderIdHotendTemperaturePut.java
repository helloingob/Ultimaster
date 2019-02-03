package de.fhl.ultimaster.api.v1.printer.heads.head_id.extruders.extruder_id.hotend.temperature;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import de.fhl.ultimaster.api.v1.printer.heads.head_id.max_speed.PrinterHeadsHeadIdMaxSpeedPutResponseParser;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperaturePut {

    /** Sets temperature of feeder.
     * @param printer Connection information of the printer
     * @param headId ID of head from which the hotend is fetched
     * @param extruderId ID of extruder from which the hotend is fetched
     * @param temperature Target temperature of nozzle
     * @return Success? */
    public static boolean put(Printer printer, long headId, long extruderId, double temperature) {
        HttpPut request = new HttpPut(printer.getUrl() + "/printer/heads/" + headId + "/extruders/" + extruderId + "/hotend/temperature");
        addParameter(request, temperature);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterHeadsHeadIdMaxSpeedPutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, double temperature) {
        //@formatter:off
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                                                                        .addTextBody("temperature", String.valueOf(temperature));
        //@formatter:on
        HttpEntity multiPartEntity = builder.build();
        request.setEntity(multiPartEntity);
    }

}
