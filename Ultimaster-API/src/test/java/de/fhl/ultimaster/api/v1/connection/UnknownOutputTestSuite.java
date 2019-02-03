package de.fhl.ultimaster.api.v1.connection;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import de.fhl.ultimaster.api.v1.connection.history.events.HistoryEventsGetTest;
import de.fhl.ultimaster.api.v1.connection.history.print_jobs.HistoryPrintJobsGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.diagnostics.cap_sensor_noise.PrinterDiagnosticsCapSensorNoiseGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.network.ssid.PrinterNetworkSsidGetTest;
import de.fhl.ultimaster.api.v1.connection.system.log.SystemLogGetTest;

@RunWith(Suite.class)

//@formatter:off
@Suite.SuiteClasses({ 
    HistoryEventsGetTest.class,
    HistoryPrintJobsGetTest.class,
    PrinterNetworkSsidGetTest.class,
    SystemLogGetTest.class,
    PrinterDiagnosticsCapSensorNoiseGetTest.class
})
//@formatter:on

public class UnknownOutputTestSuite {}
