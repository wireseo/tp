package seedu.address.logic.commands.view;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_PAST_CONSULTATIONS;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;


/**
 * View only past consultations.
 */
public class ViewPastConsultationsCommand extends ViewCommand {
    public static final String MESSAGE_SUCCESS = "Listed all past consultations";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredConsultationsList(PREDICATE_SHOW_PAST_CONSULTATIONS);

        return new CommandResult(MESSAGE_SUCCESS, ViewCommandType.ViewConsultations);
    }
}
