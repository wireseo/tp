package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalMissions.FRACTAL_DIMENSIONS;
import static seedu.address.testutil.TypicalMissions.MUSICAL_NOTES;
import static seedu.address.testutil.TypicalMissions.REUSE_PAIRS;
import static seedu.address.testutil.TypicalMissions.STREAMS;
import static seedu.address.testutil.TypicalMissions.getTypicalAddressBook;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.testutil.TypicalManagers;


public class ViewMissionDeadlineCommandTest {

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

    @Test
    public void execute_viewMissionDeadlineCommand_missionListFiltered() {
        String expectedMessage = ViewMissionDeadlineCommand.MESSAGE_SUCCESS;
        ViewMissionDeadlineCommand command = new ViewMissionDeadlineCommand();
        expectedModel.updateMissionsList(model.PREDICATE_SHOW_ALL_MISSIONS);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(FRACTAL_DIMENSIONS, MUSICAL_NOTES, REUSE_PAIRS, STREAMS),
                model.getFilteredMissionList());
    }

}
