package seedu.jarvis.logic.commands.delete;

import seedu.jarvis.commons.core.index.Index;
import seedu.jarvis.logic.commands.CommandResult;
import seedu.jarvis.logic.commands.exceptions.CommandException;
import seedu.jarvis.model.Model;

public class DeleteMasteryCheckCommand extends DeleteCommand {

    public static final String MESSAGE_DELETE_MASTERY_CHECK_USAGE = COMMAND_WORD
            + ": Deletes the mastery check identified by the mastery check ID used in the mastery check list.\n"
            + "Example: " + COMMAND_WORD + " -mc 1\n"
            + "Type \"view -mc\" to verify your task ID before deleting!";
    public static final String MESSAGE_DELETE_MASTERY_CHECK_SUCCESS = "Deleted Mastery Check: %1$s";

    public DeleteMasteryCheckCommand(Index targetIndex) {
        //super(targetIndex, "MC");
    }

    // When this is implemented, you may return a CommandResult(userFeedback, CommandTargetFeature.MasteryCheck);
    // and the tab redirecting will work.
    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException(MESSAGE_DELETE_MASTERY_CHECK_SUCCESS);
    }
}
