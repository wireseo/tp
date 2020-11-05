package seedu.jarvis.logic.commands.delete;

import seedu.jarvis.commons.core.Messages;
import seedu.jarvis.commons.core.index.Index;
import seedu.jarvis.logic.commands.CommandResult;
import seedu.jarvis.logic.commands.CommandTargetFeature;
import seedu.jarvis.logic.commands.exceptions.CommandException;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.masteryCheck.MasteryCheck;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class DeleteMasteryCheckCommand extends DeleteCommand {

    public static final String MESSAGE_DELETE_MASTERY_CHECK_USAGE = COMMAND_WORD
            + ": Deletes the mastery check identified by the mastery check ID used in the mastery check list.\n"
            + "Example: " + COMMAND_WORD + " -mc 1\n"
            + "Type \"view -mc\" to verify your task ID before deleting!";
    public static final String MESSAGE_DELETE_MASTERY_CHECK_SUCCESS = "Deleted Mastery Check: %1$s";

    private final Index index;

    /**
     * Creates an DeleteMasteryCommand to delete the specified {@code MasteryCommand}
     */
    public DeleteMasteryCheckCommand(Index index) {
        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<MasteryCheck> lastShownList = model.getFilteredMasteryChecksList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MASTERY_CHECK_DISPLAYED_INDEX);
        }

        MasteryCheck masteryCheckToDelete = lastShownList.get(index.getZeroBased());
        model.deleteMasteryCheck(masteryCheckToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_MASTERY_CHECK_SUCCESS, masteryCheckToDelete),
                CommandTargetFeature.MasteryCheck);

    }
}
