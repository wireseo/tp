package seedu.address.model;

import seedu.address.model.login.Username;

/**
 * Unmodifiable view of user login details.
 */
public interface ReadOnlyUserLogin {
    Username getUsername();
    String getUserPassword();
}
