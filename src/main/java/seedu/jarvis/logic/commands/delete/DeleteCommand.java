package seedu.jarvis.logic.commands.delete;

import seedu.jarvis.logic.commands.Command;
import seedu.jarvis.logic.commands.CommandResult;
import seedu.jarvis.logic.commands.exceptions.CommandException;
import seedu.jarvis.model.Model;

/**
 * Deletes a student identified using it's displayed index from the jarvis book.
 */
public abstract class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_DELETE_USAGE = "Delete Command supports:\n"
            + "1. delete task (delete -t)"
            + "2. delete consultation (delete -c)"
            + "3. delete mastery check (delete -mc)";

    public abstract CommandResult execute(Model model) throws CommandException;

}
