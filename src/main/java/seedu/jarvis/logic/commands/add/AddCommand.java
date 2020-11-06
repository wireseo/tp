package seedu.jarvis.logic.commands.add;

import seedu.jarvis.logic.commands.Command;
import seedu.jarvis.logic.commands.CommandResult;
import seedu.jarvis.logic.commands.exceptions.CommandException;
import seedu.jarvis.model.Model;

/**
 * Adds a student to the jarvis book.
 */
public abstract class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_ADD_USAGE = COMMAND_WORD + ": Adds a consultation or task to the jarvis book.\n"
            + "add -c NAME d/YYYY-MM-DD t/HH:MM: Add consultation with student with NAME at specified date and time\n"
            + "add -mc NAME d/YYYY-MM-DD t/HH:MM: Add mastery check with student with NAME at specified date and "
            + "time\n"
            + "add -t DESCRIPTION: Add todo with DESCRIPTION\n"
            + "add -e DESCRIPTION d/YYYY-MM-DD t/HH:MM: Add event with DESCRIPTION at specified date and time\n"
            + "add -d DESCRIPTION d/YYYY-MM-DD t/HH:MM: Add deadline with DESCRIPTION at specified date and time\n";

    public static final String MESSAGE_MISSING_DESCRIPTION = "Please include the DESCRIPTION";
    public static final String MESSAGE_MISSING_INFO = "Please make sure to include all of NAME, DATE, and TIME: NAME "
            + "d/YYYY-MM-DD t/HH:MM";
    public static final String MESSAGE_WRONG_DATETIME_FORMAT = "The date time format is incorrect. Correct format: "
            + "d/YYYY-MM-DD t/HH:MM";
    public static final String MESSAGE_INVALID_DATETIME = "The provided date and time is incorrect.\nBe careful of "
            + "leap years and the number of days in a specific month";

    public abstract CommandResult execute(Model model) throws CommandException;

}
