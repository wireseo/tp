package seedu.address.logic.commands.view;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.CommandTargetFeature;
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
    public static final String MESSAGE_SUCCESS = "You are looking at your students who match the search: %1$s";
    private final Name searchedName;

    /**
     * Creates a ViewOneStudentCommand object which searches for the student using their name.
     * @param name of the student to be viewed.
     */
    public ViewOneStudentCommand(Name name) {
        requireNonNull(name);
        this.searchedName = name;
    }

    /**
     * Returns a CommandResult containing the student whose name has partial matches or full name matches with the
     * searched name.
     * @param model
     * @return a command result contianing the searched student(s)
     * @throws CommandException
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        assert searchedName.fullName.length() > 0 : "The input search string is empty";
        model.updateFilteredPersonList(student ->
                student.getName().fullName.contains(searchedName.toString())
                || student.getName().fullName.toLowerCase().contains(searchedName.toString()));
        ObservableList<Student> filteredResult = model.getFilteredStudentList();
        if (filteredResult.size() == 0) {
            // reset the list to show all persons
            model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_STUDENTS);
            throw new CommandException(Messages.MESSAGE_STUDENT_NAME_NOT_FOUND);
        } else {
            return new CommandResult(String.format(MESSAGE_SUCCESS, searchedName), CommandTargetFeature.Students);
        }
    }

}
