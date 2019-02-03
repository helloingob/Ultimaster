package de.fhl.ultimaster.api.v1.printer.diagnostics.cap_sensor_noise.loop_count;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;

public class PrinterDiagnosticsCapSensorNoiseLoopCountGet {

    /** Calculates noise variances on the cap sensor by executing the specified loop_count iterations, each iteration measuring 50 samples.
     * @param printer Connection information of the printer
     * @param loopCount The number of times to get sample data
     * @return Noise variances */
    public static String get(Printer printer, int loopCount) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/diagnostics/cap_sensor_noise/" + loopCount);
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterDiagnosticsCapSensorNoiseLoopCountGetResponseParser.parse(response);
    }

}
