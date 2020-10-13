package seedu.address.logic.commands.exceptions;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_PAST_CONSULTATIONS;

/**
 * View only past consultations.
 */
public class ViewPastConsultationsCommand extends ViewCommand {
    public static String MESSAGE_RESULT = "";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        MESSAGE_RESULT = model.getConsultations(PREDICATE_SHOW_PAST_CONSULTATIONS).toString();

        return new CommandResult(MESSAGE_RESULT);
    }
}
