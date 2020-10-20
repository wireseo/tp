package seedu.address.logic.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.testutil.TypicalManagers;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

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
