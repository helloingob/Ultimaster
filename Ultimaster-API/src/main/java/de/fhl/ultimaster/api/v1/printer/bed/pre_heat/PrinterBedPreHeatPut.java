package de.fhl.ultimaster.api.v1.printer.bed.pre_heat;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import de.fhl.ultimaster.api.v1.printer.bed.temperature.PrinterBedTemperaturePutResponseParser;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterBedPreHeatPut {

    /** Set the temperature of the bed.
     * @param printer Connection information of the printer
     * @param temperature Target temperature of bed in degrees Celsius
     * @param timeout *OPTIONAL* Timeout for preheating in seconds
     * @return Success? */
    public static boolean put(Printer printer, double temperature, Double timeout) {
        HttpPut request = new HttpPut(printer.getUrl() + "/printer/bed/pre_heat");
        addParameter(request, temperature, timeout);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterBedTemperaturePutResponseParser.parse(response);
    }

    private static void addParameter(HttpPut request, double temperature, Double timeout) {
        //@formatter:off
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                                                                        .addTextBody("temperature", String.valueOf(temperature));
        //@formatter:on
        if (timeout != null) {
            builder.addTextBody("timeout", String.valueOf(timeout));
        }
        HttpEntity multiPartEntity = builder.build();
        request.setEntity(multiPartEntity);
    }

}
