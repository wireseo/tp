package seedu.address.model.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Represents a Deadline task.
 */
public class Deadline extends Task {

    private final String taskId;
    private final String description;
    private final LocalDateTime dateTime;

    /**
     * Creates a Deadeline object that has taskId, description, date and time attributes.
     * @param description
     * @param dateTime
     */
    public Deadline(String description, LocalDateTime dateTime) {
        this.taskId = generateTaskId();
        this.description = description;
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
        return "D" + taskNum;
    }

    /**
     * Returns true if both tasks have the same task id.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof seedu.address.model.task.Deadline)) {
            return false;
        }

        Deadline otherTask = (Deadline) other;
        return this.taskId.equals(otherTask.getTaskId());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[")
                .append(getTaskId())
                .append("] ")
                .append(getDescription())
                .append(" by ")
                .append(getDateTime());

        return builder.toString();
    }
}
