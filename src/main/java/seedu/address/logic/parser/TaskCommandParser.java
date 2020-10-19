package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.TASK_DATE;
import static seedu.address.logic.parser.CliSyntax.TASK_TIME;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Event;
import seedu.address.model.task.Todo;

/**
 * Parses input add task arguments and creates a new Specified Task object
 */
public class TaskCommandParser {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

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
        LocalDateTime formattedEventDateTime;

        try {
            formattedEventDateTime = parseTimedTaskTime(nameKeywords, length);
        } catch (ParseException pe) {
            throw pe;
        }

        String eventDescription = parseTimedTaskDescription(nameKeywords, length);

        return new Event(eventDescription, formattedEventDateTime);
    }

    /**
     * Takes in user input parameters and creates a Deadline.
     * Returns a deadline task.
     */
    public static Deadline parseDeadline(String[] nameKeywords, int length) throws ParseException {
        LocalDateTime formattedDeadlineDateTime;

        try {
            formattedDeadlineDateTime = parseTimedTaskTime(nameKeywords, length);
        } catch (ParseException pe) {
            throw pe;
        }

        String deadlineDescription = parseTimedTaskDescription(nameKeywords, length);

        return new Deadline(deadlineDescription, formattedDeadlineDateTime);
    }

    /**
     * Parses timed event description
     * @param nameKeywords
     * @param length
     * @return String of description
     */
    public static String parseTimedTaskDescription(String[] nameKeywords, int length) {
        int datePrefixLocation = -1;
        for (int i = 2; i < length; i++) {
            if (nameKeywords[i].substring(0, 2).equals(TASK_DATE)) {
                datePrefixLocation = i;
            }
        }

        String taskDescription = nameKeywords[1];
        for (int i = 2; i < datePrefixLocation; i++) {
            taskDescription = taskDescription + " " + nameKeywords[i];
        }

        return taskDescription;
    }

    /**
     * Parses the date time String to LocalDateTime object with checks
     * @param nameKeywords
     * @param length
     * @return LocalDateTime
     * @throws ParseException
     */
    public static LocalDateTime parseTimedTaskTime(String[] nameKeywords, int length) throws ParseException {
        boolean hasDatePrefix = false;
        boolean hasTimePrefix = false;
        int datePrefixLocation = -1;
        int timePrefixLocation = -1;

        for (int i = 2; i < length; i++) {
            if (nameKeywords[i].substring(0, 2).equals(TASK_DATE)) {
                hasDatePrefix = true;
                datePrefixLocation = i;
            }

            if (nameKeywords[i].substring(0, 2).equals(TASK_TIME)) {
                hasTimePrefix = true;
                timePrefixLocation = i;
            }
        }

        if (datePrefixLocation > timePrefixLocation) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_WRONG_DATETIME_FORMAT));

        } else if (!hasDatePrefix || !hasTimePrefix) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_MISSING_DATE));
        }

        LocalDateTime formattedDateTime;
        try {
            formattedDateTime = parseDateTimeString(nameKeywords[datePrefixLocation], nameKeywords[timePrefixLocation]);

        } catch (ParseException pe) {
            throw pe;
        }

        return formattedDateTime;
    }

    /**
     * Formats the datetime String to LocalDateTime object
     * @param dateString
     * @param timeString
     * @return LocalDateTime object
     * @throws ParseException
     */
    public static LocalDateTime parseDateTimeString(String dateString, String timeString)
            throws ParseException {
        String taskDateTime = dateString.substring(2) + " " + timeString.substring(2);
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime formattedEventDateTime;

        try {
            formattedEventDateTime = LocalDateTime.parse(taskDateTime, dateTimeFormat);
        } catch (DateTimeParseException e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_WRONG_DATETIME_FORMAT));
        }

        return formattedEventDateTime;
    }
}
