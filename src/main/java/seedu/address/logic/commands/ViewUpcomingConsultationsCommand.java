package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_UPCOMING_CONSULTATIONS;

import seedu.address.model.Model;

/**
 * View only past consultations.
 */
public class ViewUpcomingConsultationsCommand extends ViewCommand {

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        String result = model.getConsultations(PREDICATE_SHOW_UPCOMING_CONSULTATIONS).toString();

        return new CommandResult(result);
    }
}
