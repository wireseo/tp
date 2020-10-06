package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;

/**
 * Lists the student specified by the user, either by the list index or the name of the student.
 */
public class ViewOneStudentCommand extends ViewCommand {

    // Note that name specified in the command is case sensitive.
    public static final String SAMPLE_COMMAND = "view -s Alex Yeoh";
    public static final String MESSAGE_SUCCESS = "You are looking at your student: %1$s";
    private final Name name;

    /**
     * Creates a ViewOneStudentCommand object which searches for the student using their name.
     * @param name of the student to be viewed.
     */
    public ViewOneStudentCommand(Name name) {
        this.name = name;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        model.updateFilteredPersonList(student -> student.getName().equals(name));
        ObservableList<Student> filteredResult = model.getFilteredPersonList();
        if (filteredResult.size() == 0) {
            throw new CommandException(Messages.MESSAGE_STUDENT_NAME_NOT_FOUND);
        } else {
            return new CommandResult(String.format(MESSAGE_SUCCESS, name));
        }
    }
}
