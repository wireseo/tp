package seedu.address.testutil;

import java.nio.file.Path;
import java.nio.file.Paths;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserLogin;
import seedu.address.model.UserPrefs;
import seedu.address.model.login.Username;
import seedu.address.storage.JsonAddressBookStorage;
import seedu.address.storage.JsonUserLoginStorage;
import seedu.address.storage.JsonUserPrefsStorage;
import seedu.address.storage.Storage;
import seedu.address.storage.StorageManager;

public class TypicalManagers {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonAddressBookStorageTest");

    public static UserLogin getUserLogin() {
        return new UserLogin();
    }

    public static UserLogin getPopUserLogin(Username username, String password) {
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(username);
        userLogin.setPassword(password);
        return userLogin;
    }

    public static UserPrefs getUserPrefs() {
        return new UserPrefs();
    }

    public static JsonAddressBookStorage getJsonAddressBookStorage() {
        return new JsonAddressBookStorage(Paths.get("typicalPersonsAddressBook.json"));
    }

    public static JsonUserPrefsStorage getJsonUserPrefsStorage() {
        return new JsonUserPrefsStorage(Paths.get("TypicalUserPref.json"));
    }

    public static JsonUserLoginStorage getJsonUserLoginStorage() {
        return new JsonUserLoginStorage(Paths.get("EmptyUserLogin.json"));
    }

    public static Storage getStorage() {
        return new StorageManager(getJsonAddressBookStorage(), getJsonUserPrefsStorage(), getJsonUserLoginStorage());
    }

    public static Model getModel() {
        return new ModelManager(TypicalStudents.getTypicalAddressBook(), getUserPrefs(), getUserLogin());
    }
}
