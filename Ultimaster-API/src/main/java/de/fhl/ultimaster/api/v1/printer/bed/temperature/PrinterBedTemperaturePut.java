package de.fhl.ultimaster.api.v1.printer.bed.temperature;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterBedTemperaturePut {

    /** Set the temperature of the bed.
     * @param printer Connection information of the printer
     * @param temperature Target temperature of bed
     * @return Success? */
    public static boolean put(Printer printer, double temperature) {
        HttpPut request = new HttpPut(printer.getUrl() + "/printer/bed/temperature");
        addParameter(request, temperature);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterBedTemperaturePutResponseParser.parse(response);
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
