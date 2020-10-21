package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonAdaptedQuest {
    private final String title;
    private final String deadline;

    /**
     * Constructs a Json-friendly Quest object.
     * @param title quest's title
     * @param deadline quest's deadline
     */
    public JsonAdaptedQuest(@JsonProperty("title") String title, @JsonProperty("deadline") String deadline) {
        this.title = title;
        this.deadline = deadline;
    }
}
