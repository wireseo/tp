package seedu.address.logic.commands.exceptions;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_PAST_CONSULTATIONS;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.model.Model;

/**
 * View only past consultations.
 */
public class ViewPastConsultationsCommand extends ViewCommand {
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        String result = model.getConsultations(PREDICATE_SHOW_PAST_CONSULTATIONS).toString();

        return new CommandResult(result);
    }
}
