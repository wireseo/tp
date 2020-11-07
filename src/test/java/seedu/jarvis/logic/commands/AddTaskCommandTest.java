package seedu.jarvis.logic.commands;

import static seedu.jarvis.testutil.Assert.assertThrows;
import static seedu.jarvis.testutil.TypicalMissions.getTypicalAddressBook;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TODO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.jarvis.logic.commands.add.AddTaskCommand;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.ModelManager;
import seedu.jarvis.testutil.TypicalManagers;

public class AddTaskCommandTest {
    private Model model;
    private Model expectedModel;

    @Test
    public void execute_emptyModel_throwsNullPointerException() {
        Model emptyModel = null;
        AddTaskCommand AddTaskCommandTodo = new AddTaskCommand(TEST_TODO);
        assertThrows(NullPointerException.class, () -> AddTaskCommandTodo.execute(emptyModel));
    }

    @BeforeEach
    public void execute_addDuplicate_throwsNullPointerException() {
        model = new ModelManager(getTypicalAddressBook(), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
        AddTaskCommand AddTaskCommandTodo = new AddTaskCommand(TEST_TODO);
        assertThrows(NullPointerException.class, () -> AddTaskCommandTodo.execute(model));
    }
}
