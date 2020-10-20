package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.ViewPastConsultationsCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.testutil.TypicalManagers;

public class ViewPastConsultationsCommandTest {

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
        Command command = new ViewPastConsultationsCommand();
        String expectedMessage = ViewPastConsultationsCommand.MESSAGE_SUCCESS; // TODO: Fix this expected message
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    // TODO: implement test to check if actual output is correct

    @Test
    public void execute_emptyModel_throwsNullPointerException() {
        Model emptyModel = null;
        ViewPastConsultationsCommand viewPastConsultationsCommand = new ViewPastConsultationsCommand();
        assertThrows(NullPointerException.class, () -> viewPastConsultationsCommand.execute(emptyModel));
    }
}
