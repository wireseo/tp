package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showStudentAtIndex;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ViewAllStudentsCommand.
 */
public class ViewAllStudentsCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_studentListNotFiltered_showsSameList() {
        assertCommandSuccess(new ViewAllStudentsCommand(), model,
                ViewAllStudentsCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_studentListIsFiltered_showsEverything() {
        showStudentAtIndex(model, INDEX_FIRST_PERSON);
        assertCommandSuccess(new ViewAllStudentsCommand(), model,
                ViewAllStudentsCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_emptyModel_throwsNullPointerException() {
        Model emptyModel = null;
        ViewAllStudentsCommand viewAllStudentsCommand = new ViewAllStudentsCommand();
        assertThrows(NullPointerException.class, () -> viewAllStudentsCommand.execute(emptyModel));
    }
}
