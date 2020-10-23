package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.EDIT_LOGIN;
import static seedu.address.logic.parser.CliSyntax.EDIT_STUDENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TELEGRAM;
import java.util.Arrays;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditStudentCommand;
import seedu.address.logic.commands.EditStudentCommand.EditPersonDescriptor;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.flag.Flag;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditStudentCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditStudentCommand parse(String args) throws ParseException {
        requireNonNull(args);

        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
        }

        // split the string trimmedArgs with regex of one or more whitespace characters.
        // result will be as such: {-s, Alex, Yeoh}
        String[] inputsAfterCommandType = trimmedArgs.split("\\s+");
        assert inputsAfterCommandType.length > 0 : "String array of the arguments is empty";
        Flag commandFlag = ParserUtil.parseFlag(inputsAfterCommandType[0]);

        switch (commandFlag.getFlag()) {
        case EDIT_STUDENT:
            String studentEditArgs = String.join(" ", Arrays.copyOfRange(inputsAfterCommandType, 1,
                    inputsAfterCommandType.length));
            ArgumentMultimap argMultimap =
                    ArgumentTokenizer.tokenize(studentEditArgs, PREFIX_NAME, PREFIX_TELEGRAM, PREFIX_EMAIL);

            Index index;

            try {
                index = ParserUtil.parseIndex(argMultimap.getPreamble());
            } catch (ParseException pe) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditStudentCommand.MESSAGE_USAGE), pe);
            }

            EditPersonDescriptor editPersonDescriptor = new EditPersonDescriptor();
            if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
                editPersonDescriptor.setName(ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()));
            }
            if (argMultimap.getValue(PREFIX_TELEGRAM).isPresent()) {
                editPersonDescriptor.setTelegram(ParserUtil.parseTelegram(argMultimap.getValue(PREFIX_TELEGRAM).get()));
            }
            if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
                editPersonDescriptor.setEmail(ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()));
            }

            if (!editPersonDescriptor.isAnyFieldEdited()) {
                throw new ParseException(EditStudentCommand.MESSAGE_NOT_EDITED);
            }

            return new EditStudentCommand(index, editPersonDescriptor);

        case EDIT_LOGIN:


        default:
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditStudentCommand.MESSAGE_USAGE));
        }
    }
}
