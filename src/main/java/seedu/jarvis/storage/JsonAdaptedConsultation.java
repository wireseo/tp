package seedu.jarvis.storage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonAdaptedConsultation {

    private final String studentName;
    private final String dateAndTime;

    /**
     * Constructs a Json-friendly Mission object.
     * @param studentName consultation subject
     * @param dateAndTime consultation date and time
     */
    public JsonAdaptedConsultation(@JsonProperty("studentName") String studentName, @JsonProperty("dateAndTime")
            String dateAndTime) {
        this.studentName = studentName;
        this.dateAndTime = dateAndTime;
    }
}
