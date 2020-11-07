package seedu.jarvis.ui;

import static seedu.jarvis.testutil.TypicalStudents.getTypicalAddressBook;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.io.TempDir;

import seedu.jarvis.logic.Logic;
import seedu.jarvis.logic.LogicManager;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.ModelManager;
import seedu.jarvis.storage.JsonAddressBookStorage;
import seedu.jarvis.storage.JsonUserLoginStorage;
import seedu.jarvis.storage.JsonUserPrefsStorage;
import seedu.jarvis.storage.StorageManager;
import seedu.jarvis.testutil.TypicalManagers;

public class MainWindowTest {

    // Integration and unit tests combined

    @TempDir
    public Path temporaryFolder;

    // This model is used to execute commands
    private Model model;

    private Logic logic;

    @BeforeAll
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
        JsonAddressBookStorage addressBookStorage =
                new JsonAddressBookStorage(temporaryFolder.resolve("jarvis.json"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(temporaryFolder.resolve("userPrefs.json"));
        JsonUserLoginStorage userLoginStorage = new JsonUserLoginStorage(temporaryFolder.resolve("userLogin.json"));
        StorageManager storage = new StorageManager(addressBookStorage, userPrefsStorage, userLoginStorage);
        logic = new LogicManager(model, storage);
    }

    // Every possible command has to be tested here
}
