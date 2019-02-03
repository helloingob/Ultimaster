package de.fhl.ultimaster.gui.view.diagnostics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.pmw.tinylog.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import de.fhl.ultimaster.api.v1.history.events.HistoryEventsGet;
import de.fhl.ultimaster.api.v1.materials.MaterialsGet;
import de.fhl.ultimaster.api.v1.objects.LogLine;
import de.fhl.ultimaster.api.v1.objects.json.Event;
import de.fhl.ultimaster.api.v1.objects.json.Extruder;
import de.fhl.ultimaster.api.v1.objects.json.Head;
import de.fhl.ultimaster.api.v1.objects.json.Printer;
import de.fhl.ultimaster.api.v1.objects.xml.FdmMaterial;
import de.fhl.ultimaster.api.v1.printer.PrinterGet;
import de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow.PrinterDiagnosticsTemperatureFlowGet;
import de.fhl.ultimaster.api.v1.printer.diagnostics.temperature_flow.TemperatureFlowData;
import de.fhl.ultimaster.api.v1.system.LogLineParser;
import de.fhl.ultimaster.api.v1.system.SystemGet;
import de.fhl.ultimaster.gui.utils.TimeHelper;
import de.fhl.ultimaster.shared.printer.PrinterDAO;

public class DiagnosticsController extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = 8764850580645396961L;
    private Div divChart;
    private Listbox lbxLogs;
    private Listbox lbxEvents;
    private Listbox lbxExtruder;
    private Textbox tbxSearchLogs;
    private Textbox tbxSearchEvents;
    private Listheader lhdDateEvents;
    private Listheader lhdDateLogs;

    private de.fhl.ultimaster.api.v1.objects.json.System system;
    private Printer printer;
    private List<Event> events;
    private List<FdmMaterial> fdmMaterials;
    List<TemperatureFlowData> temperatureFlow;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    @Override
    public void doAfterCompose(Component comp) {
        try {
            super.doAfterCompose(comp);
        } catch (Exception e) {
            Logger.error(e);
        }
        init();
    }

    private void init() {
        retrieveDate();
        if (system != null) {
            drawChart();
            fillLogs();
        }
        if (events != null) {
            fillEvents();
        }
        if (printer != null) {
            fillExtruder();
        }
        lhdDateLogs.setSortAscending(new DateComparator(true));
        lhdDateLogs.setSortDescending(new DateComparator(false));
        lhdDateLogs.sort(false);
        lhdDateEvents.setSortAscending(new DateComparator(true));
        lhdDateEvents.setSortDescending(new DateComparator(false));
        lhdDateEvents.sort(false);
    }

    private void retrieveDate() {
        de.fhl.ultimaster.shared.printer.Printer printerConnection = PrinterDAO.get();
        system = SystemGet.get(printerConnection);
        printer = PrinterGet.get(printerConnection);
        events = HistoryEventsGet.get(printerConnection, null, null, null);
        temperatureFlow = PrinterDiagnosticsTemperatureFlowGet.getTemperatureFlow(printerConnection, 50);
        fdmMaterials = MaterialsGet.getSerialized(printerConnection);
    }

    private void fillExtruder() {
        int headCount = 0;
        for (Head head : printer.getHeads()) {
            headCount++;
            int extruderCount = 0;
            for (Extruder extruder : head.getExtruders()) {
                extruderCount++;
                lbxExtruder.appendChild(ExtruderHandler.get(fdmMaterials, extruder, headCount, extruderCount));
            }
        }
    }

    private void fillLogs() {
        for (String logLineStr : system.getLogLines()) {
            LogLine logLine = LogLineParser.getLogLine(logLineStr);
            addLogListitem(logLine);
        }
    }

    private void fillEvents() {
        for (Event event : events) {
            addEventListitem(event);
        }
    }

    private void addEventListitem(Event event) {
        Listitem listitem = new Listitem();
        LocalDateTime localDateTime = LocalDateTime.parse(event.getTime());
        listitem.appendChild(new Listcell(localDateTime.format(dateTimeFormatter)));
        listitem.appendChild(new Listcell(event.getMessage()));
        Label label = new Label();
        label.setMultiline(true);
        label.setValue(String.join(",\n", event.getParameters()));
        Listcell listcell = new Listcell();
        listcell.appendChild(label);
        listitem.appendChild(listcell);
        listitem.setValue(localDateTime);
        lbxEvents.appendChild(listitem);
    }

    private void addLogListitem(LogLine logLine) {
        Listitem listitem = new Listitem();
        listitem.appendChild(new Listcell(logLine.getDate().format(dateTimeFormatter)));
        listitem.appendChild(new Listcell(logLine.getProcess() + " [" + logLine.getPid() + "]"));
        listitem.appendChild(new Listcell(logLine.getLine()));
        listitem.setValue(logLine.getDate());
        lbxLogs.appendChild(listitem);
    }

    private void drawChart() {
        if (system != null) {
            ChartHandler.generateChart(divChart, temperatureFlow, TimeHelper.getBootTimestamp(system));
        }
    }

    public void onOK$tbxSearchLogs() {
        search(lbxLogs, tbxSearchLogs.getText());
    }

    public void onOK$tbxSearchEvents() {
        search(lbxEvents, tbxSearchEvents.getText());
    }

    private void search(Listbox listbox, String searchString) {
        for (Listitem listitem : listbox.getItems()) {
            for (Component component : listitem.getChildren()) {
                listitem.setVisible(false);
                Listcell listcell = (Listcell) component;
                if (listcell.getLabel().toLowerCase().contains(searchString.toLowerCase()) || searchString.isEmpty()) {
                    listitem.setVisible(true);
                    break;
                }
            }
        }
    }

}
