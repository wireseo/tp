package seedu.address.logic.commands.edit;

import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TELEGRAM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_USERNAME;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public abstract class EditCommand extends Command {
    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits information stored in Jarvis according to the " + "command inputted.\n"
            + "edit -s [index number used in student list] "
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_TELEGRAM + "TELEGRAM] "
            + "[" + PREFIX_EMAIL + "EMAIL] "
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_TELEGRAM + "example132 "
            + PREFIX_EMAIL + "johndoe@example.com\n"
            + "edit -l "
            + "[" + PREFIX_USERNAME + "USERNAME] "
            + "[" + PREFIX_PASSWORD + "PASSWORD] ";

    @Override
    public abstract CommandResult execute(Model model) throws CommandException;
}
