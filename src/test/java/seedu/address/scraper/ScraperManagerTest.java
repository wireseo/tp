package seedu.address.scraper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScraperManagerTest {

    @Test
    public void constructor_nullUserLogin_throwsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> new ScraperManager(null, null));
    }

}
