package seedu.address.logic.commands.view;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_UPCOMING_MASTERY_CHECKS;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists only upcoming mastery checks.
 */
public class ViewUpcomingMasteryChecksCommand extends ViewCommand {
    public static final String MESSAGE_SUCCESS = "Listed upcoming mastery check sessions";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateMasteryChecksList(PREDICATE_SHOW_UPCOMING_MASTERY_CHECKS);

        return new CommandResult(MESSAGE_SUCCESS);
    }
}