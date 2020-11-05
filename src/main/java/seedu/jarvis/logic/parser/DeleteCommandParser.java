package seedu.jarvis.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.jarvis.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.jarvis.logic.commands.delete.DeleteCommand.MESSAGE_DELETE_USAGE;
import static seedu.jarvis.logic.parser.CliSyntax.DELETE_CONSULTATION;
import static seedu.jarvis.logic.parser.CliSyntax.DELETE_MASTERY_CHECK;
import static seedu.jarvis.logic.parser.CliSyntax.DELETE_TASK;

import java.util.Arrays;
import java.util.logging.Logger;

import seedu.jarvis.commons.core.LogsCenter;
import seedu.jarvis.commons.core.index.Index;
import seedu.jarvis.logic.commands.delete.DeleteCommand;
import seedu.jarvis.logic.commands.delete.DeleteConsultationCommand;
import seedu.jarvis.logic.commands.delete.DeleteMasteryCheckCommand;
import seedu.jarvis.logic.commands.delete.DeleteTaskCommand;
import seedu.jarvis.logic.parser.exceptions.ParseException;
import seedu.jarvis.model.flag.Flag;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    private static final Logger logger = LogsCenter.getLogger(DeleteCommandParser.class);
    private static final String EMPTY_DELETE_COMMAND = "Parameters should not be empty for delete commands; enter id.";

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        requireNonNull(args);

        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_DELETE_USAGE));
        }

        // split the string trimmedArgs with regex of one or more whitespace characters.
        String[] inputsAfterCommandType = trimmedArgs.split("\\s+");
        assert inputsAfterCommandType.length > 0 : "String array of the arguments is empty";

        Flag commandFlag;
        try {
            commandFlag = ParserUtil.parseFlag(inputsAfterCommandType[0]);
        } catch (ParseException ex) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_DELETE_USAGE));
        }

        String editArgs = String.join(" ", Arrays.copyOfRange(inputsAfterCommandType, 1,
                inputsAfterCommandType.length));

        if (editArgs.length() <= 0) { // when editArgs is empty (no command after delete -flag)
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, EMPTY_DELETE_COMMAND));
        }

        String[] split = editArgs.split("\\s+");

        switch(commandFlag.getFlag()) {
        case DELETE_TASK:
            logger.info("DeleteCommandParser attempts to parse user's delete Task input");
            try {
                String taskId = TaskCommandParser.parseDeleteTask(inputsAfterCommandType);
                return new DeleteTaskCommand(taskId);

            } catch (ParseException pe) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteTaskCommand.MESSAGE_DELETE_TASK_USAGE), pe);
            }
        case DELETE_CONSULTATION:
            logger.info("DeleteCommandParser attempts to parse user's delete Consultation input");
            Index consultationIndex;

            try {
                consultationIndex = ParserUtil.parseIndex(split[0]);
            } catch (ParseException pe) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                                DeleteConsultationCommand.MESSAGE_DELETE_CONSULTATION_USAGE), pe);
            }

            return new DeleteConsultationCommand(consultationIndex);

        case DELETE_MASTERY_CHECK:
            logger.info("DeleteCommandParser attempts to parse user's delete MasteryCheck input");
            Index masteryCheckIndex;

            try {
                masteryCheckIndex = ParserUtil.parseIndex(split[0]);
            } catch (ParseException pe) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                                DeleteMasteryCheckCommand.MESSAGE_DELETE_MASTERY_CHECK_USAGE), pe);
            }

            return new DeleteMasteryCheckCommand(masteryCheckIndex);

        default:
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_DELETE_USAGE));
        }
    }

}
