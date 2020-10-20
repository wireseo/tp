package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CONSULTATIONS;

import seedu.address.model.Model;

/**
 * View all consultations.
 */
public class ViewConsultationsCommand extends ViewCommand {
    public static final String MESSAGE_SUCCESS = "Listed all consultations: \n";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        String result = model.getConsultations(PREDICATE_SHOW_ALL_CONSULTATIONS).toString();
        if (result.equals("[]")) {
            result = "";
        }

        return new CommandResult(MESSAGE_SUCCESS + result);
    }
}
