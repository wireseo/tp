package seedu.jarvis.logic.commands;

import static seedu.jarvis.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.jarvis.testutil.Assert.assertThrows;
import static seedu.jarvis.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.jarvis.logic.commands.view.ViewConsultationsCommand;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.ModelManager;
import seedu.jarvis.testutil.TypicalManagers;

public class ViewConsultationsCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
        expectedModel = new ModelManager(model.getAddressBook(), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
    }

    @Test
    public void execute_noFilters_success() {
        Command command = new ViewConsultationsCommand();
        String expectedMessage = ViewConsultationsCommand.MESSAGE_SUCCESS; // TODO: Fix this expected message
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    // TODO: implement test to check if actual output is correct

    @Test
    public void execute_emptyModel_throwsNullPointerException() {
        Model emptyModel = null;
        ViewConsultationsCommand viewConsultationsCommand = new ViewConsultationsCommand();
        assertThrows(NullPointerException.class, () -> viewConsultationsCommand.execute(emptyModel));
    }
}
