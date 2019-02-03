package de.fhl.ultimaster.api.v1.connection;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import de.fhl.ultimaster.api.v1.connection.camera.CameraGetTest;
import de.fhl.ultimaster.api.v1.connection.camera.feed.CameraFeedGetTest;
import de.fhl.ultimaster.api.v1.connection.history.events.HistoryEventsGetTest;
import de.fhl.ultimaster.api.v1.connection.history.print_jobs.HistoryPrintJobsGetTest;
import de.fhl.ultimaster.api.v1.connection.materials.MaterialsGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.PrintJobGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.name.PrintJobNameGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.progress.PrintJobProgressGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.reprint_original_uuid.PrintJobReprintOriginalUuidGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.source.PrintJobSourceGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.source_application.PrintJobSourceApplicationGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.source_user.PrintJobSourceUserGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.state.PrintJobStateGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.time_elapsed.PrintJobTimeElapsedGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.time_total.PrintJobTimeTotalGetTest;
import de.fhl.ultimaster.api.v1.connection.print_job.uuid.PrintJobUuidGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.PrinterGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.bed.PrinterBedGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.bed.pre_heat.PrinterBedPreHeatGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.bed.temperature.PrinterBedTemperatureGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.diagnostics.temperature_flow.PrinterDiagnosticsTemperatureFlowGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.heads.PrinterHeadsGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.led.PrinterLedGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.network.PrinterNetworkGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.network.ssid.PrinterNetworkSsidGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.network.wifi_networks.PrinterNetworkWifiNetworksGetTest;
import de.fhl.ultimaster.api.v1.connection.printer.status.PrinterStatusGetTest;
import de.fhl.ultimaster.api.v1.connection.system.SystemGetTest;
import de.fhl.ultimaster.api.v1.connection.system.country.SystemCountryGetTest;
import de.fhl.ultimaster.api.v1.connection.system.guid.SystemGuidGetTest;
import de.fhl.ultimaster.api.v1.connection.system.hardware.revision.SystemHardwareRevisionGetTest;
import de.fhl.ultimaster.api.v1.connection.system.hardware.typeid.SystemHardwareTypeidGetTest;
import de.fhl.ultimaster.api.v1.connection.system.language.SystemLanguageGetTest;
import de.fhl.ultimaster.api.v1.connection.system.log.SystemLogGetTest;
import de.fhl.ultimaster.api.v1.connection.system.name.SystemNameGetTest;
import de.fhl.ultimaster.api.v1.connection.system.type.SystemTypeGetTest;
import de.fhl.ultimaster.api.v1.connection.system.uptime.SystemUptimeGetTest;
import de.fhl.ultimaster.api.v1.connection.system.variant.SystemVariantGetTest;

@RunWith(Suite.class)

//@formatter:off
@Suite.SuiteClasses({ 
    CameraGetTest.class,
    CameraFeedGetTest.class,
    HistoryEventsGetTest.class,
    HistoryPrintJobsGetTest.class,
    MaterialsGetTest.class,
    PrinterBedPreHeatGetTest.class,
    PrinterBedGetTest.class,
    PrinterBedTemperatureGetTest.class,
    //PrinterDiagnosticsCapSensorNoiseLoopCountGetTest.class,
    //PrinterDiagnosticsCapSensorNoiseLoopCountSampleCountGetTest.class,
    //PrinterDiagnosticsCapSensorNoiseGetTest.class,
    PrinterDiagnosticsTemperatureFlowGetTest.class,
    PrinterHeadsGetTest.class,
    PrinterLedGetTest.class,
    PrinterNetworkGetTest.class,
    PrinterNetworkSsidGetTest.class,
    PrinterNetworkWifiNetworksGetTest.class,
    PrinterGetTest.class,
    PrinterStatusGetTest.class,
    PrintJobNameGetTest.class,
    PrintJobGetTest.class,
    PrintJobProgressGetTest.class,
    PrintJobReprintOriginalUuidGetTest.class,
    PrintJobSourceGetTest.class,
    PrintJobSourceApplicationGetTest.class,
    PrintJobSourceUserGetTest.class,
    PrintJobStateGetTest.class,
    PrintJobTimeElapsedGetTest.class,
    PrintJobTimeTotalGetTest.class,
    PrintJobUuidGetTest.class,
    SystemCountryGetTest.class,
    SystemGuidGetTest.class,
    SystemHardwareRevisionGetTest.class,
    SystemHardwareTypeidGetTest.class,
    SystemLanguageGetTest.class,
    SystemLogGetTest.class,
    SystemNameGetTest.class,
    SystemGetTest.class,
    SystemTypeGetTest.class,
    SystemUptimeGetTest.class,
    SystemVariantGetTest.class
})
//@formatter:on

public class ConnectionGetTestSuite {}
