package de.fhl.ultimaster.api.v1.printer.diagnostics.cap_sensor_noise;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterDiagnosticsCapSensorNoiseGet {

    /** Calculates noise variances on the cap sensor by executing taking 100 values, each loop measuring 50 samples.
     * @param printer Connection information of the printer
     * @return Noise variances */
    public static String get(Printer printer) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/diagnostics/cap_sensor_noise");
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterDiagnosticsCapSensorNoiseGetResponseParser.parse(response);
    }

}
