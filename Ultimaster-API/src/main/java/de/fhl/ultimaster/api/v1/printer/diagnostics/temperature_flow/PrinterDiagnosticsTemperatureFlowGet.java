package de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow;

import de.fhl.ultimaster.connection.RestConnection;
import de.fhl.ultimaster.shared.printer.Printer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public class PrinterDiagnosticsTemperatureFlowGet {

    /** Gets historical temperature & flow data.
     * @param printer Connection information of the printer
     * @param sampleCount The amount of samples to get
     * @return Array of sample data */
    public static String get(Printer printer, int sampleCount) {
        String response = get(printer, sampleCount, false);
        if (response != null) {
            return response;
        }
        return null;
    }

    /** Gets historical temperature & flow data as CSV
     * @param printer Connection information of the printer
     * @param sampleCount The amount of samples to get
     * @return List of {@link TemperatureFlowData} */
    public static List<TemperatureFlowData> getTemperatureFlow(Printer printer, int sampleCount) {
        String csv = getCSV(printer, sampleCount);
        List<TemperatureFlowData> temperatureFlowDataList = new ArrayList<>();
        if (csv != null) {
            List<String> lines = new LinkedList<String>(Arrays.asList(csv.split("\n")));
            //remove header
            lines.remove(0);
            for (String line : lines) {
                temperatureFlowDataList.add(TemperatureFlowCsvParser.getTemperatureFlowDate(line));
            }
        }
        return temperatureFlowDataList;
    }

    /** Gets historical temperature & flow data as CSV
     * @param printer Connection information of the printer
     * @param sampleCount The amount of samples to get
     * @return Sample data as CSV */
    public static String getCSV(Printer printer, int sampleCount) {
        return get(printer, sampleCount, true);
    }

    private static String get(Printer printer, int sampleCount, boolean csv) {
        HttpGet request = new HttpGet(printer.getUrl() + "/printer/diagnostics/temperature_flow/" + sampleCount + (csv ? "?csv=1" : ""));
        HttpResponse response = RestConnection.execute(printer, request);
        return PrinterDiagnosticsTemperatureFlowGetResponseParser.parse(response);
    }

}
