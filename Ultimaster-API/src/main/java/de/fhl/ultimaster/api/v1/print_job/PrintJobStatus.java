package de.fhl.ultimaster.api.v1.print_job;

/**
 *  The status of the Print Job.
 *  <li>{@link #PRINTING}</li>
 *  <li>{@link #PAUSING}</li>
 *  <li>{@link #PAUSED}</li>
 *  <li>{@link #RESUMING}</li>
 *  <li>{@link #PRE_PRINT}</li>
 *  <li>{@link #POST_PRINT}</li>
 *  <li>{@link #WAIT_CLEANUP}</li>
 */
public enum PrintJobStatus {

    /** Print is currently busy. Most common state. */
    PRINTING,
    /**  Print was busy and the printer is in the process of going to the paused state. This usually does not last long. */
    PAUSING,
    /**  Print is paused and thus will not finish without used interaction. */
    PAUSED,
    /** Print is resuming after a pause. Could be heating up the hotend again so this can take a while. */
    RESUMING,
    /**  Preparing to print. This is the state before any gcode is run. Active leveling is done during this state as well as heating up the bed/hotends. */
    PRE_PRINT,
    /** Print is finished, cooling down things and homing the head. This state lasts a while because of how the hotends are properly released from filament. (user can skip part of this at the machine) */
    POST_PRINT,
    /**  Print is fully finished, everything is cooled down. But the print still needs to be removed from the printer. This waits for a conformation of the user at the printer itself. */
    WAIT_CLEANUP,
    /**  Only for debug & test. */
    NONE

}
