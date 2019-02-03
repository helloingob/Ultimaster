package de.fhl.ultimaster.gui.view.diagnostics;

import java.util.List;
import org.zkoss.zk.ui.event.AfterSizeEvent;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Div;
import de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow.TemperatureFlowData;

public class ChartHandler {

    public static void generateChart(Div div, List<TemperatureFlowData> temperatureFlowDataList, double bootTimestamp) {
        div.addEventListener(Events.ON_AFTER_SIZE, getDivAfterSizeListener(div, temperatureFlowDataList, bootTimestamp));
        drawChart(div, temperatureFlowDataList, bootTimestamp);
    }

    private static void drawChart(Div div, List<TemperatureFlowData> temperatureFlowDataList, double bootTimestamp) {
        String chartString = generateHighchart(div.getUuid(), ChartSeriesConverter.generateSeries(temperatureFlowDataList, bootTimestamp));
        Clients.evalJavaScript("Highcharts.setOptions({ time: { timezoneOffset: -2*60 } });new Highcharts.Chart(" + chartString + ");");
    }

    private static String generateHighchart(String divChartId, String series) {
        // @formatter:off
        return "{ " +
                    "chart: { type: 'line', renderTo: '" + divChartId + "' }," +
                    "title: { text: null }," +
                    "yAxis: { title: { text:null }, labels: { formatter: function () { return this.value + ' C';} } }," +
                    "credits: { enabled: false }," +
                    "tooltip: { pointFormat: '{series.name}: <b>{point.y}</b><br/>', valueSuffix: ' cm', shared: true }," +
                    "legend: { enabled: true }," +
                    "tooltip: { shared: true }," +
                    "xAxis: {  type: 'datetime', labels: { format: '{value:%H:%M:%S}', rotation: 90 }, crosshair: true }," +
                    "series: [" +series+ "]" +
                "}";
        // @formatter:on
    }

    private static EventListener<AfterSizeEvent> getDivAfterSizeListener(Div div, List<TemperatureFlowData> temperatureFlowDataList, double bootTimestamp) {
        return new EventListener<AfterSizeEvent>() {
            @Override
            public void onEvent(AfterSizeEvent event) throws Exception {
                drawChart(div, temperatureFlowDataList, bootTimestamp);
            }
        };
    }

}
