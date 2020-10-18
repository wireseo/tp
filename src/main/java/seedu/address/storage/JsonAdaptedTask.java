package seedu.address.storage;

import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.model.student.Student;
import seedu.address.model.task.Task;

public class JsonAdaptedTask {

    private final String id;
    private final String description;
    private final String dateTime;

    /**
     * Constructs a Json-friendly task object with the given task details.
     * @param id task's id
     * @param description task's description
     * @param dateTime task's date and time
     */
    public JsonAdaptedTask(@JsonProperty("id") String id, @JsonProperty("description") String description,
                           @JsonProperty("dateTime") String dateTime) {
        this.id = id;
        this.description = description;
        this.dateTime = dateTime;
    }

    /**
     * Converts a given {@code Task} into this class for Jackson use.
     */
    public JsonAdaptedTask(Task source) {
        id = source.getTaskId();
        description = source.getDescription();
        dateTime = source.getPossibleDateTime(source);
    }
}
