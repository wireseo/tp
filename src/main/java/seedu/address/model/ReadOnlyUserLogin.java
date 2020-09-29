package seedu.address.model;

/**
 * Unmodifiable view of user login details.
 */
public interface ReadOnlyUserLogin {
    String getUsername();
    String getUserPassword();
}
