package seedu.address.logic.commands.view;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CONSULTATIONS;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * View all consultations.
 */
public class ViewConsultationsCommand extends ViewCommand {
    public static final String MESSAGE_SUCCESS = "Listed all consultations";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateConsultationsList(PREDICATE_SHOW_ALL_CONSULTATIONS);

        return new CommandResult(MESSAGE_SUCCESS);
    }
}
