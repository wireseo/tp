package seedu.jarvis.logic.commands;

import static seedu.jarvis.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.jarvis.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.jarvis.logic.commands.CommandTestUtil.showConsultationAtIndex;
import static seedu.jarvis.testutil.TypicalConsultations.TEST_CONSULTATION_ONE;
import static seedu.jarvis.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.jarvis.testutil.TypicalIndexes.INDEX_SECOND;
import static seedu.jarvis.testutil.TypicalStudents.getTypicalAddressBook;
import static seedu.jarvis.testutil.TypicalTasks.EVENT2;
import static seedu.jarvis.testutil.TypicalTasks.TODO2;

import org.junit.jupiter.api.Test;

import seedu.jarvis.commons.core.Messages;
import seedu.jarvis.commons.core.index.Index;
import seedu.jarvis.logic.commands.delete.DeleteConsultationCommand;
import seedu.jarvis.logic.commands.delete.DeleteTaskCommand;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.ModelManager;
import seedu.jarvis.model.consultation.Consultation;
import seedu.jarvis.model.task.Event;
import seedu.jarvis.model.task.Todo;
import seedu.jarvis.testutil.TypicalManagers;

public class DeleteTaskCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), TypicalManagers.getUserPrefs(),
            TypicalManagers.getUserLogin());

    @Test
    //There is no need to test for filtered and unfiltered lists as deleting task is based on unique Id assigned to each
    //task upon creation.
    public void execute_validIndexList_success() {
        Todo toDeleteTask = TODO2;
        model.addTodo(toDeleteTask);
        String toDeleteId = toDeleteTask.getTaskId();
        DeleteTaskCommand deleteCommand = new DeleteTaskCommand(toDeleteId);

        String expectedMessage =
                String.format(DeleteTaskCommand.MESSAGE_DELETE_TASK_SUCCESS, toDeleteTask);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), TypicalManagers.getUserPrefs(),
                TypicalManagers.getUserLogin());
        expectedModel.deleteTask(toDeleteTask);

        assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexList_throwsCommandException() {
        model.addEvent(EVENT2);
        String wrongId = "ABC123";
        DeleteTaskCommand deleteCommand = new DeleteTaskCommand(wrongId);
        assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_ID);
    }
}
