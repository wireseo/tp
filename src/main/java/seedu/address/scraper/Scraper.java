package seedu.address.scraper;

import java.io.IOException;

import seedu.address.commons.exceptions.WrongLoginDetailsException;

public interface Scraper {
    void startScraping() throws WrongLoginDetailsException, IOException;
}
