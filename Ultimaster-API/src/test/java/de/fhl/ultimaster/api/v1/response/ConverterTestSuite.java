package de.fhl.ultimaster.api.v1.response;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import de.fhl.ultimaster.api.v1.response.materials.XmlParserTest;
import de.fhl.ultimaster.api.v1.response.printer.diagnostics.temperature_flow.TemperatureFlowDataTest;
import de.fhl.ultimaster.api.v1.response.system.LogLineParserTest;

@RunWith(Suite.class)

//@formatter:off
@Suite.SuiteClasses({ 
    XmlParserTest.class,
    TemperatureFlowDataTest.class,
    LogLineParserTest.class
})
//@formatter:on

public class ConverterTestSuite {
}
