package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_QUESTS;

import seedu.address.model.Model;

/**
 * Lists all quest deadlines.
 */
public class ViewQuestDeadlineCommand extends ViewCommand {
    public static final String MESSAGE_SUCCESS = "Listed all quest deadlines";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateMissionsList(PREDICATE_SHOW_ALL_QUESTS);

        return new CommandResult(MESSAGE_SUCCESS);
    }
}
