package seedu.address.model.task;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Represents an Event task.
 */
public class Event extends Task {

    private final String taskId;
    private final String description;
    private final LocalDateTime dateTime;

    /**
     * Creates an Event object that has taskId, description, date and time attributes.
     * @param description
     * @param dateTime
     */
    public Event(String description, LocalDateTime dateTime) {
        this.taskId = generateTaskId();
        requireNonNull(description);
        this.description = description;
        requireNonNull(dateTime);
        this.dateTime = dateTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getDateTime() {
        return dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }


    /**
     * Returns a unique task id.
     */
    public String generateTaskId() {
        int taskNum = Task.getTaskNum();
        Task.taskNumInc();
        return "E" + taskNum;
    }

    /**
     * Returns true if both tasks have the same task id.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof seedu.address.model.task.Event)) {
            return false;
        }

        Event otherTask = (Event) other;
        return this.taskId.equals(otherTask.getTaskId());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[")
                .append(getTaskId())
                .append("] ")
                .append(getDescription())
                .append(" at ")
                .append(getDateTime());

        return builder.toString();
    }
}
