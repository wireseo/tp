package seedu.address.logic.commands;

import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_UPCOMING_CONSULTATIONS;

/**
 * View only past consultations.
 */
public class ViewUpcomingConsultationsCommand extends ViewCommand {
    public static String MESSAGE_RESULT = "";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        MESSAGE_RESULT = model.getConsultations(PREDICATE_SHOW_UPCOMING_CONSULTATIONS).toString();

        return new CommandResult(MESSAGE_RESULT);
    }
}
