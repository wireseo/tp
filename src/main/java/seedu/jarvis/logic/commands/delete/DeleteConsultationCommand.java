package seedu.jarvis.logic.commands.delete;

import seedu.jarvis.commons.core.index.Index;

public class DeleteConsultationCommand extends DeleteCommand {
    public DeleteConsultationCommand(Index targetIndex) {
        super(targetIndex, "C");
    }

    // When this is implemented, you may return a CommandResult(userFeedback, CommandTargetFeature.Consultations);
    // and the tab redirecting will work.
}
