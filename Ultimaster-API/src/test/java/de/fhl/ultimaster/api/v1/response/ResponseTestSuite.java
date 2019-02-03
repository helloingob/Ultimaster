package de.fhl.ultimaster.api.v1.response;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import de.fhl.ultimaster.api.v1.response.auth.check.id.AuthCheckIdGetTest;
import de.fhl.ultimaster.api.v1.response.auth.request.AuthRequestPostTest;
import de.fhl.ultimaster.api.v1.response.auth.verify.AuthVerifyGetTest;
import de.fhl.ultimaster.api.v1.response.beep.BeepPutTest;
import de.fhl.ultimaster.api.v1.response.camera.CameraGetTest;
import de.fhl.ultimaster.api.v1.response.camera.feed.CameraFeedGetTest;
import de.fhl.ultimaster.api.v1.response.camera.index.snapshot.CameraIndexSnapshotGetTest;
import de.fhl.ultimaster.api.v1.response.camera.index.stream.CameraIndexStreamGetTest;
import de.fhl.ultimaster.api.v1.response.history.events.HistoryEventsGetTest;
import de.fhl.ultimaster.api.v1.response.history.events.HistoryEventsPostTest;
import de.fhl.ultimaster.api.v1.response.history.print_jobs.HistoryPrintJobsGetTest;
import de.fhl.ultimaster.api.v1.response.history.print_jobs.uuid.HistoryPrintJobsUuidGetTest;
import de.fhl.ultimaster.api.v1.response.materials.MaterialsGetTest;
import de.fhl.ultimaster.api.v1.response.materials.MaterialsPostTest;
import de.fhl.ultimaster.api.v1.response.materials.material_guid.MaterialsMaterialGuidDeleteTest;
import de.fhl.ultimaster.api.v1.response.materials.material_guid.MaterialsMaterialGuidGetTest;
import de.fhl.ultimaster.api.v1.response.materials.material_guid.MaterialsMaterialGuidPutTest;
import de.fhl.ultimaster.api.v1.response.print_job.PrintJobGetTest;
import de.fhl.ultimaster.api.v1.response.print_job.PrintJobPostTest;
import de.fhl.ultimaster.api.v1.response.print_job.name.PrintJobNameGetTest;
import de.fhl.ultimaster.api.v1.response.print_job.progress.PrintJobProgressGetTest;
import de.fhl.ultimaster.api.v1.response.print_job.reprint_original_uuid.PrintJobReprintOriginalUuidGetTest;
import de.fhl.ultimaster.api.v1.response.print_job.source.PrintJobSourceGetTest;
import de.fhl.ultimaster.api.v1.response.print_job.source_application.PrintJobSourceApplicationGetTest;
import de.fhl.ultimaster.api.v1.response.print_job.source_user.PrintJobSourceUserGetTest;
import de.fhl.ultimaster.api.v1.response.print_job.state.PrintJobStateGetTest;
import de.fhl.ultimaster.api.v1.response.print_job.state.PrintJobStatePutTest;
import de.fhl.ultimaster.api.v1.response.print_job.time_elapsed.PrintJobTimeElapsedGetTest;
import de.fhl.ultimaster.api.v1.response.print_job.time_total.PrintJobTimeTotalGetTest;
import de.fhl.ultimaster.api.v1.response.print_job.uuid.PrintJobUuidGetTest;
import de.fhl.ultimaster.api.v1.response.printer.PrinterGetTest;
import de.fhl.ultimaster.api.v1.response.printer.bed.PrinterBedGetTest;
import de.fhl.ultimaster.api.v1.response.printer.bed.pre_heat.PrinterBedPreHeatGetTest;
import de.fhl.ultimaster.api.v1.response.printer.bed.pre_heat.PrinterBedPreHeatPutTest;
import de.fhl.ultimaster.api.v1.response.printer.bed.temperature.PrinterBedTemperatureGetTest;
import de.fhl.ultimaster.api.v1.response.printer.bed.temperature.PrinterBedTemperaturePutTest;
import de.fhl.ultimaster.api.v1.response.printer.diagnostics.cap_sensor_noise.loop_count.PrinterDiagnosticsCapSensorNoiseLoopCountGetTest;
import de.fhl.ultimaster.api.v1.response.printer.diagnostics.cap_sensor_noise.loop_count.sample_count.PrinterDiagnosticsCapSensorNoiseLoopCountSampleCountGetTest;
import de.fhl.ultimaster.api.v1.response.printer.diagnostics.temperature_flow.PrinterDiagnosticsTemperatureFlowGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.PrinterHeadsGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.PrinterHeadsHeadIdGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.acceleration.PrinterHeadsHeadIdAccelerationGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.acceleration.PrinterHeadsHeadIdAccelerationPutTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.PrinterHeadsHeadIdExtrudersGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.PrinterHeadsHeadIdExtrudersExtruderIdGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.active_material.PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.active_material.guid.PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGuidGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.active_material.length_remaining.PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialLengthRemainingGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.PrinterHeadsHeadIdExtrudersExtruderIdFeederGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.acceleration.PrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.acceleration.PrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationPutTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.jerk.PrinterHeadsHeadIdExtrudersExtruderIdFeederJerkGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.jerk.PrinterHeadsHeadIdExtrudersExtruderIdFeederJerkPutTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.max_speed.PrinterHeadsHeadIdExtrudersExtruderIdFeederMaxSpeedGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.feeder.max_speed.PrinterHeadsHeadIdExtrudersExtruderIdFeederMaxSpeedPutTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.hotend.PrinterHeadsHeadIdExtrudersExtruderIdHotendGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.hotend.offset.PrinterHeadsHeadIdExtrudersExtruderIdHotendOffsetGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.hotend.temperature.PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperatureGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.extruders.extruder_id.hotend.temperature.PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperaturePutTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.jerk.PrinterHeadsHeadIdJerkGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.jerk.PrinterHeadsHeadIdJerkPutTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.max_speed.PrinterHeadsHeadIdMaxSpeedGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.max_speed.PrinterHeadsHeadIdMaxSpeedPutTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.position.PrinterHeadsHeadIdPositionGetTest;
import de.fhl.ultimaster.api.v1.response.printer.heads.head_id.position.PrinterHeadsHeadIdPositionPutTest;
import de.fhl.ultimaster.api.v1.response.printer.led.PrinterLedGetTest;
import de.fhl.ultimaster.api.v1.response.printer.led.PrinterLedPutTest;
import de.fhl.ultimaster.api.v1.response.printer.led.blink.PrinterLedBlinkPostTest;
import de.fhl.ultimaster.api.v1.response.printer.network.PrinterNetworkGetTest;
import de.fhl.ultimaster.api.v1.response.printer.network.ssid.PrinterNetworkSsidGetTest;
import de.fhl.ultimaster.api.v1.response.printer.network.wifi_networks.PrinterNetworkWifiNetworksGetTest;
import de.fhl.ultimaster.api.v1.response.printer.network.wifi_networks.ssid.PrinterNetworkWifiNetworksSsidDeleteTest;
import de.fhl.ultimaster.api.v1.response.printer.network.wifi_networks.ssid.PrinterNetworkWifiNetworksSsidPutTest;
import de.fhl.ultimaster.api.v1.response.printer.status.PrinterStatusGetTest;
import de.fhl.ultimaster.api.v1.response.printer.validate_header.PrinterValidateHeaderGetTest;
import de.fhl.ultimaster.api.v1.response.system.SystemGetTest;
import de.fhl.ultimaster.api.v1.response.system.country.SystemCountryGetTest;
import de.fhl.ultimaster.api.v1.response.system.country.SystemCountryPutTest;
import de.fhl.ultimaster.api.v1.response.system.display_message.SystemDisplayMessagePutTest;
import de.fhl.ultimaster.api.v1.response.system.guid.SystemGuidGetTest;
import de.fhl.ultimaster.api.v1.response.system.language.SystemLanguageGetTest;
import de.fhl.ultimaster.api.v1.response.system.log.SystemLogGetTest;
import de.fhl.ultimaster.api.v1.response.system.name.SystemNameGetTest;
import de.fhl.ultimaster.api.v1.response.system.name.SystemNamePutTest;
import de.fhl.ultimaster.api.v1.response.system.revision.SystemRevisionGetTest;
import de.fhl.ultimaster.api.v1.response.system.system.variant.SystemVariantGetTest;
import de.fhl.ultimaster.api.v1.response.system.type.SystemTypeGetTest;
import de.fhl.ultimaster.api.v1.response.system.uptime.SystemUptimeGetTest;

@RunWith(Suite.class)

//@formatter:off
@Suite.SuiteClasses({ 
    AuthCheckIdGetTest.class,
    AuthRequestPostTest.class,
    AuthVerifyGetTest.class,
    BeepPutTest.class,
    CameraGetTest.class,
    CameraFeedGetTest.class,
    CameraIndexSnapshotGetTest.class,
    CameraIndexStreamGetTest.class,
    HistoryEventsGetTest.class,
    HistoryEventsPostTest.class,
    HistoryPrintJobsGetTest.class,
    HistoryPrintJobsUuidGetTest.class,
    MaterialsGetTest.class,
    MaterialsPostTest.class,
    MaterialsMaterialGuidDeleteTest.class,
    MaterialsMaterialGuidGetTest.class,
    MaterialsMaterialGuidPutTest.class,
    PrinterBedPreHeatGetTest.class,
    PrinterBedPreHeatPutTest.class,
    PrinterBedGetTest.class,
    PrinterBedTemperatureGetTest.class,
    PrinterBedTemperaturePutTest.class,
    PrinterDiagnosticsCapSensorNoiseLoopCountGetTest.class,
    PrinterDiagnosticsCapSensorNoiseLoopCountSampleCountGetTest.class,
    PrinterDiagnosticsTemperatureFlowGetTest.class,
    PrinterDiagnosticsTemperatureFlowGetTest.class,
    PrinterHeadsHeadIdAccelerationGetTest.class,
    PrinterHeadsHeadIdAccelerationPutTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGuidGetTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialLengthRemainingGetTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdActiveMaterialGetTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationGetTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdFeederAccelerationPutTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdFeederJerkGetTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdFeederJerkPutTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdFeederMaxSpeedGetTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdFeederMaxSpeedPutTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdFeederGetTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdHotendOffsetGetTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdHotendGetTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperatureGetTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdHotendTemperaturePutTest.class,
    PrinterHeadsHeadIdExtrudersExtruderIdGetTest.class,
    PrinterHeadsHeadIdExtrudersGetTest.class,
    PrinterHeadsHeadIdJerkGetTest.class,
    PrinterHeadsHeadIdJerkPutTest.class,
    PrinterHeadsHeadIdMaxSpeedGetTest.class,
    PrinterHeadsHeadIdMaxSpeedPutTest.class,
    PrinterHeadsHeadIdPositionGetTest.class,
    PrinterHeadsHeadIdPositionPutTest.class,
    PrinterHeadsHeadIdGetTest.class,
    PrinterHeadsGetTest.class,
    PrinterLedBlinkPostTest.class,
    PrinterLedGetTest.class,
    PrinterLedPutTest.class,
    PrinterNetworkGetTest.class,
    PrinterNetworkSsidGetTest.class,
    PrinterNetworkWifiNetworksGetTest.class,
    PrinterNetworkWifiNetworksSsidDeleteTest.class,
    PrinterNetworkWifiNetworksSsidPutTest.class,
    PrinterGetTest.class,
    PrinterStatusGetTest.class,
    PrinterValidateHeaderGetTest.class,
    PrintJobNameGetTest.class,
    PrintJobGetTest.class,
    PrintJobPostTest.class,
    PrintJobProgressGetTest.class,
    PrintJobReprintOriginalUuidGetTest.class,
    PrintJobSourceGetTest.class,
    PrintJobSourceApplicationGetTest.class,
    PrintJobSourceUserGetTest.class,
    PrintJobStateGetTest.class,
    PrintJobStatePutTest.class,
    PrintJobTimeElapsedGetTest.class,
    PrintJobTimeTotalGetTest.class,
    PrintJobUuidGetTest.class,
    SystemCountryGetTest.class,
    SystemCountryPutTest.class,
    SystemDisplayMessagePutTest.class,
    SystemGuidGetTest.class,
    SystemLanguageGetTest.class,
    SystemLogGetTest.class,
    SystemNameGetTest.class,
    SystemNamePutTest.class,
    SystemRevisionGetTest.class,
    SystemVariantGetTest.class,
    SystemGetTest.class,
    SystemTypeGetTest.class,
    SystemTypeGetTest.class,
    SystemUptimeGetTest.class
})
//@formatter:on

public class ResponseTestSuite {}
