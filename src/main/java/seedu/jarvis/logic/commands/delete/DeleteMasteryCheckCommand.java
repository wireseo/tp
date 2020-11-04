package seedu.jarvis.logic.commands.delete;

import seedu.jarvis.commons.core.index.Index;

public class DeleteMasteryCheckCommand extends DeleteCommand {

    public DeleteMasteryCheckCommand(Index targetIndex) {
        super(targetIndex, "MC");
    }

    // When this is implemented, you may return a CommandResult(userFeedback, CommandTargetFeature.MasteryCheck);
    // and the tab redirecting will work.
}
