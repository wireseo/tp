package seedu.address.commons.exceptions;

/**
 * Signals that the user's operating system is not supported.
 */
public class OsNotSupportedException extends Exception {
    /**
     * @param operatingSystem The operating system the user is running
     */
    public OsNotSupportedException(String operatingSystem) {
        super(operatingSystem + " not supported");
    }
}
