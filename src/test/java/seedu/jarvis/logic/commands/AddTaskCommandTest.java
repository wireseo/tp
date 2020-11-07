package seedu.jarvis.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.jarvis.testutil.Assert.assertThrows;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TODO;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.jarvis.logic.commands.add.AddConsultationCommand;
import seedu.jarvis.logic.commands.add.AddTaskCommand;
import seedu.jarvis.logic.commands.exceptions.CommandException;
import seedu.jarvis.model.AddressBook;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.ReadOnlyAddressBook;
import seedu.jarvis.model.consultation.Consultation;
import seedu.jarvis.model.task.Deadline;
import seedu.jarvis.model.task.Event;
import seedu.jarvis.model.task.Task;
import seedu.jarvis.model.task.Todo;
import seedu.jarvis.testutil.ConsultationBuilder;
import seedu.jarvis.testutil.EventBuilder;
import seedu.jarvis.testutil.ModelStub;
import seedu.jarvis.testutil.TodoBuilder;

public class AddTaskCommandTest {

    @Test
    public void constructor_nullTask_throwsNullPointerException() {
        Todo todo = null;
        Event event = null;
        Deadline deadline = null;
        assertThrows(NullPointerException.class, () -> new AddTaskCommand(todo));
        assertThrows(NullPointerException.class, () -> new AddTaskCommand(event));
        assertThrows(NullPointerException.class, () -> new AddTaskCommand(deadline));
    }

    @Test
    public void execute_emptyModel_throwsNullPointerException() {
        Model emptyModel = null;
        AddTaskCommand AddTaskCommandTodo = new AddTaskCommand(TEST_TODO);
        assertThrows(NullPointerException.class, () -> AddTaskCommandTodo.execute(emptyModel));
    }

    @Test
    public void execute_taskAcceptedByModel_addSuccessful() throws CommandException {
        ModelStubAcceptingTaskAdded modelStub = new ModelStubAcceptingTaskAdded();
        Todo todo = new TodoBuilder().build();

        CommandResult commandResult = new AddTaskCommand(todo).execute(modelStub);

        assertEquals(String.format(AddTaskCommand.MESSAGE_SUCCESS_TODO, todo),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(todo), modelStub.tasksAdded);
    }

    @Test
    public void execute_duplicateTask_throwsCommandException() {
        Event validEvent = new EventBuilder().build();
        AddTaskCommand addCommand = new AddTaskCommand(validEvent);
        ModelStub modelStub = new ModelStubWithTask(validEvent);

        assertThrows(CommandException.class,
                AddTaskCommand.MESSAGE_DUPLICATE_TASK, () -> addCommand.execute(modelStub));
    }

    /**
     * A Model stub that contains a single task.
     */
    private class ModelStubWithTask extends ModelStub {
        private final Task task;

        ModelStubWithTask(Task task) {
            requireNonNull(task);
            this.task = task;
        }

        @Override
        public boolean hasTask(Task task) {
            requireNonNull(task);
            return this.task.equals(task);
        }

        @Override
        public boolean hasTodo(Todo todo) {
            requireNonNull(todo);
            return this.task.equals(todo);
        }

        @Override
        public boolean hasEvent(Event event) {
            requireNonNull(event);
            return this.task.equals(event);
        }

        @Override
        public boolean hasDeadline(Deadline deadline) {
            requireNonNull(deadline);
            return this.task.equals(deadline);
        }
    }

    /**
     * A Model stub that always accept the task being added.
     */
    private class ModelStubAcceptingTaskAdded extends ModelStub {
        final ArrayList<Task> tasksAdded = new ArrayList<>();

        @Override
        public boolean hasTask(Task task) {
            requireNonNull(task);
            return tasksAdded.stream().anyMatch(task::equals);
        }

        @Override
        public void addTask(Task task) {
            requireNonNull(task);
            tasksAdded.add(task);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }
}
