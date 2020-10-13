package seedu.address.logic.commands;


import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CONSULTATIONS;

/**
 * View all consultations.
 */
public class ViewConsultationsCommand extends ViewCommand {
    public static final String MESSAGE_RESULT = "";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.getConsultations(PREDICATE_SHOW_ALL_CONSULTATIONS);

        return new CommandResult(MESSAGE_RESULT);
    }
}
