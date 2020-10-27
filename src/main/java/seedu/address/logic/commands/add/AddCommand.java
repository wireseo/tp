package seedu.address.logic.commands.add;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.CommandTargetFeature;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.consultation.Consultation;
import seedu.address.model.consultation.MasteryCheck;
import seedu.address.model.student.Student;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Event;
import seedu.address.model.task.Todo;

/**
 * Adds a student to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";
    public static final String TO_ADD_STUDENT = "S";
    public static final String TO_ADD_TODO = "T";
    public static final String TO_ADD_EVENT = "E";
    public static final String TO_ADD_DEADLINE = "D";
    public static final String TO_ADD_CONSULTATION = "C";
    public static final String TO_ADD_MASTERY_CHECK = "MC";

    public static final String MESSAGE_SUCCESS = "New student added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This student already exists in jarvis";
    public static final String MESSAGE_INVALID_TO_ADD_TYPE = "This object to add is unidentifiable";
    public static final String MESSAGE_DUPLICATE_TASK = "This task already exists in jarvis";
    public static final String MESSAGE_DUPLICATE_CONSULTATION = "This consultation already exists in jarvis";
    public static final String MESSAGE_DUPLICATE_MASTERY_CHECK = "This mastery check already exists in jarvis";
    public static final String MESSAGE_SUCCESS_TODO = "New todo added: %1$s";
    public static final String MESSAGE_SUCCESS_EVENT = "New event added: %1$s";
    public static final String MESSAGE_SUCCESS_DEADLINE = "New deadline added: %1$s";
    public static final String MESSAGE_SUCCESS_CONSULTATION = "New consultation added: %1$s";
    public static final String MESSAGE_SUCCESS_MASTERY_CHECK = "New mastery check added: %1$s";

    public static final String MESSAGE_ADD_USAGE = COMMAND_WORD + ": Adds a task or consultation to the address book.\n"
            + "add -t DESCRIPTION: Add todo with DESCRIPTION\n"
            + "add -e DESCRIPTION d/YYYY-MM-DD t/HH:MM: Add event with DESCRIPTION at specified date and time\n"
            + "add -d DESCRIPTION d/YYYY-MM-DD t/HH:MM: Add deadline with DESCRIPTION at specified date and time\n"
            + "add -c NAME d/YYYY-MM-DD t/HH:MM: Add consultation with student with NAME at specified date and time\n"
            + "add -mc NAME d/YYYY-MM-DD t/HH:MM: Add mastery check with student with NAME at specified date and "
            + "time\n";

    public static final String MESSAGE_MISSING_DESCRIPTION = "Please include task DESCRIPTION";
    public static final String MESSAGE_MISSING_DATE = "Please include task DATE and TIME d/YYYY-MM-DD t/HH:MM";
    public static final String MESSAGE_WRONG_DATETIME_FORMAT = "The date time format is wrong. Correct format: "
            + "d/YYYY-MM-DD t/HH:MM";

    protected final Object toAdd;
    protected final String toAddType;

    /**
     * Creates an AddCommand to add the specified {@code Student}
     */
    public AddCommand(Student student) {
        requireNonNull(student);
        toAdd = student;
        toAddType = TO_ADD_STUDENT;
    }

    /**
     * Creates an AddCommand to add the specified {@code Todo}
     */
    public AddCommand(Todo todo) {
        requireNonNull(todo);
        toAdd = todo;
        toAddType = TO_ADD_TODO;
    }

    /**
     * Creates an AddCommand to add the specified {@code Event}
     */
    public AddCommand(Event event) {
        requireNonNull(event);
        toAdd = event;
        toAddType = TO_ADD_EVENT;
    }

    /**
     * Creates an AddCommand to add the specified {@code Deadline}
     */
    public AddCommand(Deadline deadline) {
        requireNonNull(deadline);
        toAdd = deadline;
        toAddType = TO_ADD_DEADLINE;
    }

    /**
     * Creates an AddCommand to add the specified {@code Consultation}
     */
    public AddCommand(Consultation consultation) {
        requireNonNull(consultation);
        toAdd = consultation;
        toAddType = TO_ADD_CONSULTATION;
    }

    /**
     * Creates an AddCommand to add the specified {@code MasteryCheck}
     */
    public AddCommand(MasteryCheck masteryCheck) {
        requireNonNull(masteryCheck);
        toAdd = masteryCheck;
        toAddType = TO_ADD_MASTERY_CHECK;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        switch(toAddType) {
        case TO_ADD_STUDENT:
            Student toAddStudent = (Student) toAdd;
            if (model.hasPerson(toAddStudent)) {
                throw new CommandException(MESSAGE_DUPLICATE_PERSON);
            }

            model.addPerson(toAddStudent);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAddStudent), CommandTargetFeature.Students);

        case TO_ADD_TODO:
            Todo toAddTodo = (Todo) toAdd;
            if (model.hasTodo(toAddTodo)) {
                throw new CommandException(MESSAGE_DUPLICATE_TASK);
            }

            model.addTodo(toAddTodo);
            return new CommandResult(String.format(MESSAGE_SUCCESS_TODO, toAddTodo), CommandTargetFeature.Tasks);

        case TO_ADD_EVENT:
            Event toAddEvent = (Event) toAdd;
            if (model.hasEvent(toAddEvent)) {
                throw new CommandException(MESSAGE_DUPLICATE_TASK);
            }

            model.addEvent(toAddEvent);
            return new CommandResult(String.format(MESSAGE_SUCCESS_EVENT, toAddEvent), CommandTargetFeature.Tasks);

        case TO_ADD_DEADLINE:
            Deadline toAddDeadline = (Deadline) toAdd;
            if (model.hasDeadline(toAddDeadline)) {
                throw new CommandException(MESSAGE_DUPLICATE_TASK);
            }

            model.addDeadline(toAddDeadline);
            return new CommandResult(String.format(MESSAGE_SUCCESS_DEADLINE, toAddDeadline),
                    CommandTargetFeature.Tasks);

        case TO_ADD_CONSULTATION:
            Consultation toAddConsultation = (Consultation) toAdd;
            if (model.hasConsultation(toAddConsultation)) {
                throw new CommandException(MESSAGE_DUPLICATE_CONSULTATION);
            }

            model.addConsultation(toAddConsultation);
            return new CommandResult(String.format(MESSAGE_SUCCESS_CONSULTATION, toAddConsultation));

        case TO_ADD_MASTERY_CHECK:
            MasteryCheck toAddMasteryCheck = (MasteryCheck) toAdd;
            if (model.hasMasteryCheck(toAddMasteryCheck)) {
                throw new CommandException(MESSAGE_DUPLICATE_MASTERY_CHECK);
            }

            model.addMasteryCheck(toAddMasteryCheck);
            return new CommandResult(String.format(MESSAGE_SUCCESS_MASTERY_CHECK, toAddMasteryCheck));

        default:
            throw new CommandException(MESSAGE_INVALID_TO_ADD_TYPE);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
