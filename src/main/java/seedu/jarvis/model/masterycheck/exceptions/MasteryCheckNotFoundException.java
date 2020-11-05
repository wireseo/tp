package seedu.jarvis.model.masteryCheck.exceptions;

/**
 * Signals that the operation is unable to find the specified mastery check.
 */
public class MasteryCheckNotFoundException extends RuntimeException {
    public MasteryCheckNotFoundException() {
        super("Specified mastery check not found.");
    }
}
