package seedu.address.logic.commands.view;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists all students under this tutor.
 */
public class ViewAllStudentsCommand extends ViewCommand {
    public static final String SAMPLE_COMMAND = "view -s";
    public static final String MESSAGE_SUCCESS = "Listed all students taught by you";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_STUDENTS);
        return new CommandResult(MESSAGE_SUCCESS, ViewCommandType.ViewStudents);
    }
}
