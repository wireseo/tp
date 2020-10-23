package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TELEGRAM;
import static seedu.address.logic.parser.CliSyntax.TASK_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.TASK_EVENT;
import static seedu.address.logic.parser.CliSyntax.TASK_TODO;

import java.util.logging.Logger;
import java.util.stream.Stream;

import seedu.address.MainApp;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.flag.Flag;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.Telegram;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Event;
import seedu.address.model.task.Todo;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_ADD_USAGE));
        }

        // split the string trimmedArgs with regex of one or more whitespace characters.
        String[] nameKeywords = trimmedArgs.split("\\s+");
        Flag commandFlag = ParserUtil.parseFlag(nameKeywords[0]);

        int length = nameKeywords.length;
        boolean taskHasDescription = length > 1;

        if (!taskHasDescription
                && (commandFlag.getFlag().equals(TASK_TODO) || commandFlag.getFlag().equals(TASK_EVENT)
                || commandFlag.getFlag().equals(TASK_DEADLINE))) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_MISSING_DESCRIPTION));
        }

        // switch command to return the respective add commands
        switch (commandFlag.getFlag()) {
        case TASK_TODO:
            logger.info("AddCommandParser attempts to parse user's newly added todo task");
            Todo todo = TaskCommandParser.parseTodo(nameKeywords, length);
            return new AddCommand(todo);

        case TASK_EVENT:
            logger.info("AddCommandParser attempts to parse user's newly added event task");
            Event event = TaskCommandParser.parseEvent(nameKeywords, length);
            return new AddCommand(event);

        case TASK_DEADLINE:
            logger.info("AddCommandParser attempts to parse user's newly added deadline task");
            Deadline deadline = TaskCommandParser.parseDeadline(nameKeywords, length);
            return new AddCommand(deadline);


        default:
            logger.info("AddCommandParser attempts to parse user's newly added student");
            ArgumentMultimap argMultimap =
                    ArgumentTokenizer.tokenize(args,
                            PREFIX_NAME, PREFIX_TELEGRAM, PREFIX_EMAIL);

            if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_TELEGRAM, PREFIX_EMAIL)
                    || !argMultimap.getPreamble().isEmpty()) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
            }

            Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
            Telegram telegram = ParserUtil.parseTelegram(argMultimap.getValue(PREFIX_TELEGRAM).get());
            Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());

            Student student = new Student(name, telegram, email);

            return new AddCommand(student);
        }
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
