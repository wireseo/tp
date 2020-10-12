package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ViewMissionDeadlineCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    // need to add a test case which asserts that the MissionList is empty, and not the command being invalid.
    // however we need to have methods that filter the mission list in the first place.
    @Test
    public void execute_noFilters_success() {
        Command command = new ViewMissionDeadlineCommand();
        String expectedMessage = ViewMissionDeadlineCommand.MESSAGE_SUCCESS;
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_emptyModel_throwsNullPointerException() {
        Model emptyModel = null;
        ViewMissionDeadlineCommand viewMissionDeadlineCommand = new ViewMissionDeadlineCommand();
        assertThrows(NullPointerException.class, () -> viewMissionDeadlineCommand.execute(emptyModel));
    }

}
