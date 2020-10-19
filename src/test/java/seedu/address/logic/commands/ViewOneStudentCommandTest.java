package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.student.Name;
import seedu.address.testutil.TypicalManagers;
import seedu.address.testutil.TypicalStudents;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ViewOneStudentCommand.
 */
public class ViewOneStudentCommandTest {

    private Name studentName;
    private Model model;

    @BeforeEach
    public void setUp() {
        studentName = new Name(TypicalStudents.ALICE.getName().fullName);
        model = new ModelManager(getTypicalAddressBook(), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
    }

    @Test
    public void constructor_nullStudentName_throwsNullPointerException() {
        Name name = null;
        assertThrows(NullPointerException.class, () -> new ViewOneStudentCommand(name));
    }

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        Name studentName = TypicalStudents.ALICE.getName();
        Model model = null;
        ViewOneStudentCommand viewOneStudentCommand = new ViewOneStudentCommand(studentName);
        assertThrows(NullPointerException.class, () -> viewOneStudentCommand.execute(model));
    }

    @Test
    public void execute_studentNameExists_viewSuccess() {
        Name studentName = TypicalStudents.ALICE.getName();
        Command command = new ViewOneStudentCommand(studentName);
        Model actualModel = new ModelManager(TypicalStudents.getTypicalAddressBook(), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
        String expectedMessage = String.format(ViewOneStudentCommand.MESSAGE_SUCCESS, studentName);

        Model expectedModel = new ModelManager(actualModel.getAddressBook(), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
        expectedModel.updateFilteredPersonList(student -> student.getName().equals(studentName));

        assertCommandSuccess(command, actualModel, expectedMessage, expectedModel);
    }

    @Test
    public void execute_studentNameDoesNotExist_throwsCommandException() {
        Name nonExistentName = TypicalStudents.DIMITRI.getName();
        ViewOneStudentCommand viewOneStudentCommand = new ViewOneStudentCommand(nonExistentName);
        Model actualModel = new ModelManager(getTypicalAddressBook(), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());

        assertCommandFailure(viewOneStudentCommand, actualModel, Messages.MESSAGE_STUDENT_NAME_NOT_FOUND);
    }
}
