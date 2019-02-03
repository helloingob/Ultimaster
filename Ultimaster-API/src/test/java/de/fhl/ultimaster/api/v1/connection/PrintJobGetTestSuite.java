package de.fhl.ultimaster.api.v1.connection;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

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

@RunWith(Suite.class)

//@formatter:off
@Suite.SuiteClasses({ 
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
})
//@formatter:on

public class PrintJobGetTestSuite {}
