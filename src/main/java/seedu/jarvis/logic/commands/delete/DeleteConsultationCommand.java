package seedu.jarvis.logic.commands.delete;

import seedu.jarvis.commons.core.index.Index;
import seedu.jarvis.logic.commands.CommandResult;
import seedu.jarvis.logic.commands.exceptions.CommandException;
import seedu.jarvis.model.Model;

public class DeleteConsultationCommand extends DeleteCommand {

    public static final String MESSAGE_DELETE_CONSULTATION_USAGE = COMMAND_WORD
            + ": Deletes the consultation identified by the task ID used in the consultation list.\n"
            + "Example: " + COMMAND_WORD + " -c 1\n"
            + "Type \"view -c\" to verify your task ID before deleting!";
    public static final String MESSAGE_DELETE_CONSULTATION_SUCCESS = "Deleted Consultation: %1$s";

    public DeleteConsultationCommand(Index targetIndex) {
        //super(targetIndex, "C");
    }

    // When this is implemented, you may return a CommandResult(userFeedback, CommandTargetFeature.Consultations);
    // and the tab redirecting will work.
    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException(MESSAGE_DELETE_CONSULTATION_SUCCESS);
    }
}
