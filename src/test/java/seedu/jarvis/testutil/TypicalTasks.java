package seedu.jarvis.testutil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import seedu.jarvis.model.task.Deadline;
import seedu.jarvis.model.task.Event;
import seedu.jarvis.model.task.Todo;

public class TypicalTasks {
    public static final String TEST_TASK_DESCRIPTION_FIRST = "Read book";
    public static final String TEST_TASK_DESCRIPTION_SECOND = "Sweep floor";
    public static final String TEST_TASK_DESCRIPTION_THIRD = "Wash dish";
    public static final String TEST_TASK_DESCRIPTION_FOURTH = "Eat food";

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
    private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static final LocalDateTime TEST_TASK_DATETIME_FIRST =
            LocalDateTime.parse("2020-08-26 20:20", dateTimeFormat);
    public static final LocalDateTime TEST_TASK_DATETIME_SECOND =
            LocalDateTime.parse("2021-04-20 10:20", dateTimeFormat);
    public static final LocalDateTime TEST_TASK_DATETIME_THIRD =
            LocalDateTime.parse("2020-11-06 23:30", dateTimeFormat);
    public static final LocalDateTime TEST_TASK_DATETIME_FOURTH =
            LocalDateTime.parse("2019-02-19 08:58", dateTimeFormat);
    public static final String FORMATTED_DATETIME_ONE =
            TEST_TASK_DATETIME_FIRST.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    public static final String FORMATTED_DATETIME_TWO =
            TEST_TASK_DATETIME_SECOND.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    public static final String FORMATTED_DATETIME_THREE =
            TEST_TASK_DATETIME_THIRD.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    public static final String FORMATTED_DATETIME_FOUR =
            TEST_TASK_DATETIME_FOURTH.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

    public static final Todo TEST_TODO = new Todo(TEST_TASK_DESCRIPTION_FIRST);
    public static final Event TEST_EVENT = new Event(TEST_TASK_DESCRIPTION_SECOND, TEST_TASK_DATETIME_THIRD);
    public static final Deadline TEST_DEADLINE = new Deadline(TEST_TASK_DESCRIPTION_THIRD, TEST_TASK_DATETIME_FOURTH);
}
