package seedu.jarvis.logic.commands.delete;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.jarvis.commons.core.Messages;
import seedu.jarvis.commons.core.index.Index;
import seedu.jarvis.logic.commands.Command;
import seedu.jarvis.logic.commands.CommandResult;
import seedu.jarvis.logic.commands.CommandTargetFeature;
import seedu.jarvis.logic.commands.exceptions.CommandException;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.task.Task;

/**
 * Deletes a student identified using it's displayed index from the jarvis book.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    public static final String TO_DELETE_STUDENT = "S";
    public static final String TO_DELETE_TASK = "T";
    public static final String TO_DELETE_CONSULTATION = "C";
    public static final String TO_DELETE_MASTERY_CHECK = "MC";

    public static final String MESSAGE_DELETE_USAGE = "Delete Command supports:\n"
            + "1. delete task (delete -t)";
    public static final String MESSAGE_DELETE_STUDENT_USAGE = COMMAND_WORD
            + ": Deletes the student identified by the index number used in the displayed student list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " -s 1";
    public static final String MESSAGE_DELETE_TASK_USAGE = COMMAND_WORD
            + ": Deletes the task identified by the task ID used in the task list.\n"
            + "Example: " + COMMAND_WORD + " -t T1\n"
            + "Type \"view -t\" to verify your task ID before deleting!";
    public static final String MESSAGE_DELETE_CONSULTATION_USAGE = COMMAND_WORD
            + ": Deletes the consultation identified by the task ID used in the consultation list.\n"
            + "Example: " + COMMAND_WORD + " -c 1\n"
            + "Type \"view -c\" to verify your task ID before deleting!";
    public static final String MESSAGE_DELETE_MASTERY_CHECK_USAGE = COMMAND_WORD
            + ": Deletes the mastery check identified by the mastery check ID used in the mastery check list.\n"
            + "Example: " + COMMAND_WORD + " -mc 1\n"
            + "Type \"view -mc\" to verify your task ID before deleting!";

    public static final String MESSAGE_INVALID_TO_DELETE_TYPE = "This object to delete is unidentifiable";
    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted Student: %1$s";
    public static final String MESSAGE_DELETE_TASK_SUCCESS = "Deleted Task: %1$s";
    public static final String MESSAGE_DELETE_CONSULTATION_SUCCESS = "Deleted Consultation: %1$s";
    public static final String MESSAGE_DELETE_MASTERY_CHECK_SUCCESS = "Deleted Mastery Check: %1$s";

    private final Index targetIndex;
    private final String taskId;
    private final String toDeleteType;


    /**
     * Creates an DeleteCommand to delete the specified {@code Consultation} or {@code Mastery Check}
     */
    public DeleteCommand(Index targetIndex, String toDeleteType) {
        this.targetIndex = targetIndex;
        this.taskId = null;
        this.toDeleteType = toDeleteType;
    }

    /**
     * Creates an DeleteCommand to delete the specified {@code Task}
     */
    public DeleteCommand(String taskId) {
        this.targetIndex = null;
        this.taskId = taskId;
        this.toDeleteType = TO_DELETE_TASK;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        switch(toDeleteType) {
        /*case TO_DELETE_STUDENT:
            assert targetIndex != null : "Student's delete target index should not be null";

            List<Student> lastShownList = model.getFilteredStudentList();
            if (targetIndex.getZeroBased() >= lastShownList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            }

            Student studentToDelete = lastShownList.get(targetIndex.getZeroBased());
            model.deletePerson(studentToDelete);

            return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, studentToDelete),
                    CommandTargetFeature.Students);
        */
        case TO_DELETE_TASK:
            assert taskId != null : "Task id of task to be deleted should not be null";

            List<Task> allTasks = model.getFilteredTaskList();
            Task taskToDelete = null;
            boolean hasDeletedTask = false;
            int size = allTasks.size();
            for (int i = 0; i < size; i++) {
                Task currTask = allTasks.get(i);
                if (currTask.getTaskId().equals(taskId)) {
                    taskToDelete = currTask;
                    hasDeletedTask = true;
                    break;
                }
            }

            if (hasDeletedTask) {
                assert taskToDelete != null : "Upon successful task deletion, the task deleted cannot be null";
                model.deleteTask(taskToDelete);
                return new CommandResult(String.format(MESSAGE_DELETE_TASK_SUCCESS, taskToDelete),
                        CommandTargetFeature.Tasks);

            } else {
                throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_ID);
            }

        default:
            throw new CommandException(MESSAGE_INVALID_TO_DELETE_TYPE);
        }

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteCommand) other).targetIndex)); // state check
    }
}
