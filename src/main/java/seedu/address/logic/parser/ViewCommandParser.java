package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.MISSION_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.QUEST_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.UNGRADED_MISSION;
import static seedu.address.logic.parser.CliSyntax.UNGRADED_QUEST;
import static seedu.address.logic.parser.CliSyntax.VIEW_DEADLINE_LIST;
import static seedu.address.logic.parser.CliSyntax.VIEW_EVENT_LIST;
import static seedu.address.logic.parser.CliSyntax.VIEW_STUDENT;
import static seedu.address.logic.parser.CliSyntax.VIEW_TASK_LIST;
import static seedu.address.logic.parser.CliSyntax.VIEW_TODO_LIST;

import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.ViewAllStudentsCommand;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.commands.ViewMissionDeadlineCommand;
import seedu.address.logic.commands.ViewOneStudentCommand;
import seedu.address.logic.commands.ViewQuestDeadlineCommand;
import seedu.address.logic.commands.ViewTaskListCommand;
import seedu.address.logic.commands.ViewUngradedMissionCommand;
import seedu.address.logic.commands.ViewUngradedQuestCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.flag.Flag;
import seedu.address.model.student.Name;

public class ViewCommandParser implements Parser<ViewCommand> {

    private final Logger logger = LogsCenter.getLogger(ViewCommandParser.class);

    /**
     * Parses the given {@code String} of arguments in the context of the ViewCommand
     * and returns a ViewCommand object for execution.M
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewCommand parse(String args) throws ParseException {
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
        // Problem is what if additional params here can mean more than just student name?
        boolean argsHasAdditionalParams = inputsAfterCommandType.length > 1;
        Optional<Name> optionalStudentName = Optional.empty();

        if (argsHasAdditionalParams) {
            logger.info("extra input arguments");
            String[] nameComponents = Arrays.copyOfRange(inputsAfterCommandType, 1, inputsAfterCommandType.length);
            Name studentName = ParserUtil.parseName(nameComponents);
            logger.info("Student name: " + studentName.fullName);
            optionalStudentName = Optional.of(studentName);
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

        case UNGRADED_MISSION:
            return new ViewUngradedMissionCommand();

        case UNGRADED_QUEST:
            return new ViewUngradedQuestCommand();

        case VIEW_TASK_LIST:
            return new ViewTaskListCommand(VIEW_TASK_LIST);

        case VIEW_TODO_LIST:
            return new ViewTaskListCommand(VIEW_TODO_LIST);

        case VIEW_EVENT_LIST:
            return new ViewTaskListCommand(VIEW_EVENT_LIST);

        case VIEW_DEADLINE_LIST:
            return new ViewTaskListCommand(VIEW_DEADLINE_LIST);


        // add the other cases here

        default:
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
        }

    }

}
