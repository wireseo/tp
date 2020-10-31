package seedu.jarvis.logic.commands;

import static seedu.jarvis.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.jarvis.testutil.Assert.assertThrows;
import static seedu.jarvis.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.jarvis.logic.commands.view.ViewUpcomingConsultationsCommand;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.ModelManager;
import seedu.jarvis.testutil.TypicalManagers;

public class ViewUpcomingConsultationsCommandTest {

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
        Command command = new ViewUpcomingConsultationsCommand();
        String expectedMessage = ViewUpcomingConsultationsCommand.MESSAGE_SUCCESS; // TODO: Fix this expected message
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    // TODO: implement test to check if actual output is correct

    @Test
    public void execute_emptyModel_throwsNullPointerException() {
        Model emptyModel = null;
        ViewUpcomingConsultationsCommand viewUpcomingConsultationsCommand = new ViewUpcomingConsultationsCommand();
        assertThrows(NullPointerException.class, () -> viewUpcomingConsultationsCommand.execute(emptyModel));
    }
}
