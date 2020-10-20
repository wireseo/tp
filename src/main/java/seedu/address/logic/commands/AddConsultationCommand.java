package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Consultation;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

public class AddConsultationCommand extends AddCommand {
    public AddConsultationCommand(Consultation consultation) {
        super(consultation);
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Consultation toAddConsultation = (Consultation) super.toAdd;
        if (model.hasConsultation(toAddConsultation)) {
            throw new CommandException(MESSAGE_DUPLICATE_CONSULTATION);
        }

        model.addConsultation(toAddConsultation);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAddConsultation));

    }
}
