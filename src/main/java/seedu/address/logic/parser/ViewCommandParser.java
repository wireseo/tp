package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.MISSION_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.QUEST_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.VIEW_STUDENT;
import static seedu.address.logic.parser.CliSyntax.VIEW_TASK_LIST;

import seedu.address.logic.commands.ViewAllStudentsCommand;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.commands.ViewMissionDeadlineCommand;
import seedu.address.logic.commands.ViewOneStudentCommand;
import seedu.address.logic.commands.ViewQuestDeadlineCommand;
import seedu.address.logic.commands.ViewTaskListCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.flag.Flag;
import seedu.address.model.student.Name;

import java.util.Arrays;
import java.util.Optional;

public class ViewCommandParser implements Parser<ViewCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ViewCommand
     * and returns a ViewCommand object for execution.M
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
        }

        // split the string trimmedArgs with regex of one or more whitespace characters.
        // result will be as such: {-s, Alex, Yeoh}
        String[] inputsAfterCommandType = trimmedArgs.split("\\s+");
        Flag commandFlag = ParserUtil.parseFlag(inputsAfterCommandType[0]);
        // Problem is what if additional params here can mean more than just student name?
        boolean argsHasAdditionalParams = inputsAfterCommandType.length > 1;
        Optional<Name> optionalStudentName = Optional.empty();

        if (argsHasAdditionalParams) {
            String[] nameComponents = Arrays.copyOfRange(inputsAfterCommandType, 1, inputsAfterCommandType.length);
            optionalStudentName = Optional.of(ParserUtil.parseName(nameComponents));
        }

        // switch command to return the respective view commands
        switch(commandFlag.getFlag()) {
        case MISSION_DEADLINE:
            return new ViewMissionDeadlineCommand();

        case QUEST_DEADLINE:
            return new ViewQuestDeadlineCommand();

        case VIEW_STUDENT:
            if (optionalStudentName.isPresent()) {
                Name name = optionalStudentName.get();
                return new ViewOneStudentCommand(name);
            } else {
                return new ViewAllStudentsCommand();
            }

        case VIEW_TASK_LIST:
            return new ViewTaskListCommand();

        // add the other cases here

        default:
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
        }

    }

}
