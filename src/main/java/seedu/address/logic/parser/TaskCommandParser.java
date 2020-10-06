package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.TASK_DATE;
import static seedu.address.logic.parser.CliSyntax.TASK_TIME;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Event;
import seedu.address.model.task.Todo;

/**
 * Parses input add task arguments and creates a new Specified Task object
 */
public class TaskCommandParser {
    /**
     * Takes in user input parameters and creates a Todo.
     * Returns a todo task.
     */
    public static Todo parseTodo(String[] nameKeywords, int length) {
        String description = nameKeywords[1];
        for (int i = 2; i < length; i++) {
            description = description + " " + nameKeywords[i];
        }

        return new Todo(description);
    }

    /**
     * Takes in user input parameters and creates an Event.
     * Returns an event task.
     */
    public static Event parseEvent(String[] nameKeywords, int length) throws ParseException {
        boolean hasDatePrefix = false;
        boolean hasTimePrefix = false;
        int datePrefixLocation = -1;
        int timePrefixLocation = -1;

        for (int i = 2; i < length; i++) {
            if (nameKeywords[i].substring(0, 2).equals(TASK_DATE)) {
                hasDatePrefix = true;
                datePrefixLocation = i;

            } else if (nameKeywords[i].substring(0, 2).equals(TASK_TIME)) {
                hasTimePrefix = true;
                timePrefixLocation = i;
            }
        }

        if (datePrefixLocation > timePrefixLocation) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_WRONG_DATETIME_ORDER));

        } else if (!hasDatePrefix) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_MISSING_DATE));

        } else if (!hasTimePrefix) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_MISSING_TIME));
        }

        String eventDescription = nameKeywords[1];
        for (int i = 2; i < datePrefixLocation; i++) {
            eventDescription = eventDescription + " " + nameKeywords[i];
        }

        String eventDate = nameKeywords[datePrefixLocation].substring(2);
        String eventTime = nameKeywords[timePrefixLocation].substring(2);
        return new Event(eventDescription, eventDate, eventTime);
    }

    /**
     * Takes in user input parameters and creates a Deadline.
     * Returns a deadline task.
     */
    public static Deadline parseDeadline(String[] nameKeywords, int length) throws ParseException {
        boolean hasDatePrefix = false;
        boolean hasTimePrefix = false;
        int datePrefixLocation = -1;
        int timePrefixLocation = -1;

        for (int i = 2; i < length; i++) {
            if (nameKeywords[i].substring(0, 2).equals(TASK_DATE)) {
                hasDatePrefix = true;
                datePrefixLocation = i;

            } else if (nameKeywords[i].substring(0, 2).equals(TASK_TIME)) {
                hasTimePrefix = true;
                timePrefixLocation = i;
            }
        }

        if (datePrefixLocation > timePrefixLocation) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_WRONG_DATETIME_ORDER));

        } else if (!hasDatePrefix) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_MISSING_DATE));

        } else if (!hasTimePrefix) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_MISSING_TIME));
        }

        String eventDescription = nameKeywords[1];
        for (int i = 2; i < datePrefixLocation; i++) {
            eventDescription = eventDescription + " " + nameKeywords[i];
        }

        String deadlineDate = nameKeywords[datePrefixLocation].substring(2);
        String deadlineTime = nameKeywords[timePrefixLocation].substring(2);
        return new Deadline(eventDescription, deadlineDate, deadlineTime);
    }
}
