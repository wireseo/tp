package seedu.address.model;

import static java.util.Objects.requireNonNull;

public class UserLogin implements ReadOnlyUserLogin {
    private String username = "";

    private String password = "";

    /**
     * Creates a {@code UserLogin} with default values.
     */
    public UserLogin() {}

    /**
     * Creates a {@code UserLogin} with the prefs in {@code userLogin}.
     */
    public UserLogin(ReadOnlyUserLogin userLogin) {
        this();
        resetData(userLogin);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserLogin newUserLogin) {
        requireNonNull(newUserLogin);
        setUsername(newUserLogin.getUsername());
        setPassword(newUserLogin.getUserPassword());
    }
    public String getUsername() {
        return username;
    }

    public String getUserPassword() {
        return password;
    }

    public boolean hasUsername() {
        return !username.isEmpty();
    }

    public boolean hasPassword() {
        return !password.isEmpty();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmpty() {
        return this.username.isEmpty() || this.password.isEmpty();
    }
}
