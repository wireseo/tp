package seedu.jarvis.storage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonAdaptedMasteryCheck {

    private final String studentName;
    private final String dateAndTime;
    private final String passed;

    /**
     * Constructs a Json-friendly Mission object.
     * @param studentName consultation subject
     * @param dateAndTime consultation date and time
     * @param passed mastery check passed
     */
    public JsonAdaptedMasteryCheck(@JsonProperty("studentName") String studentName, @JsonProperty("dateAndTime")
            String dateAndTime, @JsonProperty("passed") String passed) {
        this.studentName = studentName;
        this.dateAndTime = dateAndTime;
        this.passed = passed;
    }
}
