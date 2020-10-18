package seedu.address.storage;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonAdaptedTask {
    private final String id;
    private final String description;
    private final LocalDateTime dateTime;

    /**
     * Constructs a Json-friendly task object.
     * @param id task's id
     * @param description task's description
     * @param dateTime task's date and time
     */
    public JsonAdaptedTask(@JsonProperty("id") String id, @JsonProperty("description") String description, @JsonProperty("dateTime") LocalDateTime dateTime) {
        this.id = id;
        this.description = description;
        this.dateTime = dateTime;
    }
}
