package de.fhl.ultimaster.api.v1.auth.check.id;

/**
 *  The authorization status for an ID.
 *  <li>{@link #AUTHORIZED}</li>
 *  <li>{@link #UNAUTHORIZED}</li>
 *  <li>{@link #UNKNOWN}</li>
 */
public enum AuthorizationStatus {

    /** The end user has selected that this application is allowed to use the printer. */
    AUTHORIZED,
    /** The user has selected that the application is not allowed to access the printer. */
    UNAUTHORIZED,
    /** The end user has not selected any option yet */
    UNKNOWN

}
