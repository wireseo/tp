package seedu.address.testutil;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserLogin;
import seedu.address.model.UserPrefs;
import seedu.address.storage.Storage;
import seedu.address.storage.StorageManager;

public class TypicalManagers {
    public static UserLogin getUserLogin() {
        return new UserLogin();
    }

    public static UserLogin getPopUserLogin(String username, String password) {
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(username);
        userLogin.setPassword(password);
        return userLogin;
    }

    public static UserPrefs getUserPrefs() {
        return new UserPrefs();
    }

    public static Storage getStorage() {
        return new StorageManager();
    }

    public static Model getModel() {
        return new ModelManager(TypicalStudents.getTypicalAddressBook(), getUserPrefs());
    }
}
