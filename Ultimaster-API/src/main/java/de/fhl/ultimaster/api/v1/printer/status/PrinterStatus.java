package de.fhl.ultimaster.api.v1.printer.status;

/**
 *  The main status of the printer.
 *  <li>{@link #IDLE}</li>
 *  <li>{@link #PRINTING}</li>
 *  <li>{@link #ERROR}</li>
 *  <li>{@link #MAINTENANCE}</li>
 *  <li>{@link #BOOTING}</li>
 */
public enum PrinterStatus {
    /** Printer is doing nothing and ready for action. */
    IDLE,
    /**  Printer is actively printing something, or still needs to be emptied, print_job needs to be retreived for details. */
    PRINTING,
    /** Something is wrong with the printer, and requires action at the printer itself to be corrected. */
    ERROR,
    /** Someone is actively doing things with the printer, for example changing materials or PrintCores. */
    MAINTENANCE,
    /**  Printer is still starting up. This only lasts for a few seconds. */
    BOOTING
}
