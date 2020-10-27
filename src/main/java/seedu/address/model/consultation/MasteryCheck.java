package seedu.address.model.consultation;

import java.time.LocalDateTime;

public class MasteryCheck extends Consultation {
    private boolean passed;

    /**
     * Creates a {@code MasteryCheck} with the given parameters. {@code lengthOfMeeting} and {@code notes} may be null.
     *
     * @param studentName         subject of the mastery check
     * @param dateAndTime     date and time of the mastery check
     */
    public MasteryCheck(String studentName, LocalDateTime dateAndTime) {
        super(studentName, dateAndTime);
    }

    public boolean isPassed() {
        return passed;
    }

    public MasteryCheck setPassed(boolean passed) {
        this.passed = passed;
        return this;
    }

    /**
     * Creates a {@code MasteryCheck} with a full mark with the given parameters.
     */
    public static MasteryCheck createFullMarkMC(String studentName, LocalDateTime dateAndTime) {
        return new MasteryCheck(studentName, dateAndTime).setPassed(true);
    }

    /**
     * Creates a {@code MasteryCheck} with zero marks with the given parameters.
     */
    public static MasteryCheck createZeroMarkMC(String studentName, LocalDateTime dateAndTime) {
        return new MasteryCheck(studentName, dateAndTime).setPassed(false);
    }

}
