package seedu.address.commons.exceptions;

public class WrongLoginDetailsException extends ScraperParsingException {
    public WrongLoginDetailsException() {
        super("Username or email supplied is wrong");
    }
}
