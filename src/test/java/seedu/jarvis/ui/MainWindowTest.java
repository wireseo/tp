package seedu.jarvis.ui;

import static seedu.jarvis.testutil.TypicalStudents.getTypicalAddressBook;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.io.TempDir;

import seedu.jarvis.model.Model;
import seedu.jarvis.model.ModelManager;
import seedu.jarvis.testutil.TypicalManagers;

public class MainWindowTest {

    // Integration and unit tests combined

    @TempDir
    public Path temporaryFolder;

    // This model is used to execute commands
    private Model model;

    @BeforeAll
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
    }

    // Every possible command has to be tested here
}
