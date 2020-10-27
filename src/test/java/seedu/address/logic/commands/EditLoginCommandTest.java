package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_PROF;
import static seedu.address.logic.commands.CommandTestUtil.DESC_STUDENT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_USERNAME_PROF;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.edit.EditLoginCommand;
import seedu.address.logic.commands.edit.EditLoginCommand.EditLoginDescriptor;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserLogin;
import seedu.address.testutil.EditLoginDescriptorBuilder;
import seedu.address.testutil.LoginBuilder;
import seedu.address.testutil.TypicalManagers;

public class EditLoginCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), TypicalManagers.getUserPrefs(),
            TypicalManagers.getUserLogin());

    @Test
    public void execute_allFieldsSpecified_success() {
        UserLogin editedUserLogin = new LoginBuilder().build();
        EditLoginDescriptor descriptor = new EditLoginDescriptorBuilder(editedUserLogin).build();
        EditLoginCommand editLoginCommand = new EditLoginCommand(descriptor);

        String expectedMessage = String.format(EditLoginCommand.MESSAGE_EDIT_LOGIN_SUCCESS, editedUserLogin);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
        expectedModel.setUserLogin(editedUserLogin);

        assertCommandSuccess(editLoginCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_someFieldsSpecified_success() {
        UserLogin editedUserLogin = new LoginBuilder().withUsername(VALID_USERNAME_PROF).build();
        EditLoginDescriptor descriptor = new EditLoginDescriptorBuilder(editedUserLogin).build();
        EditLoginCommand editLoginCommand = new EditLoginCommand(descriptor);

        String expectedMessage = String.format(EditLoginCommand.MESSAGE_EDIT_LOGIN_SUCCESS, editedUserLogin);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
        expectedModel.setUserLogin(editedUserLogin);

        assertCommandSuccess(editLoginCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noFieldsSpecified_success() {
        EditLoginCommand editLoginCommand = new EditLoginCommand(new EditLoginDescriptor());
        UserLogin editedUserLogin = new UserLogin();

        String expectedMessage = String.format(EditLoginCommand.MESSAGE_EDIT_LOGIN_SUCCESS, editedUserLogin);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());

        assertCommandSuccess(editLoginCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void equals() {
        final EditLoginCommand standardCommand = new EditLoginCommand(DESC_STUDENT);

        // same values -> returns true
        EditLoginDescriptor copyDescriptor = new EditLoginDescriptor(DESC_STUDENT);
        EditLoginCommand commandWithSameValues = new EditLoginCommand(copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditLoginCommand(DESC_PROF)));
    }
}
