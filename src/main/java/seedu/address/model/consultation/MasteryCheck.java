package seedu.address.model.consultation;

import java.time.LocalDateTime;

import seedu.address.model.student.Student;



public class MasteryCheck extends Consultation {
    private boolean passed;

    /**
     * Creates a {@code MasteryCheck} with the given parameters. {@code lengthOfMeeting} and {@code notes} may be null.
     *
     * @param student         subject of the mastery check
     * @param dateAndTime     date and time of the mastery check
     * @param lengthOfMeeting the length of the mastery check in minutes; may be null
     * @param placeOfMeeting  place of meeting; may be a zoom link or any indicator for a meeting room at NUS
     * @param notes           any notes relevant to the mastery check; may be null
     */
    private MasteryCheck(Student student, LocalDateTime dateAndTime, int lengthOfMeeting, String placeOfMeeting,
                         String notes) {
        super(student, dateAndTime, lengthOfMeeting, placeOfMeeting, notes);
    }

    public boolean isPassed() {
        return passed;
    }

    public MasteryCheck setPassed(boolean passed) {
        this.passed = passed;
        return this;
    }

    /**
     * Creates a {@code MasteryCheck} with a full mark with the given parameters. {@code lengthOfMeeting} and
     * {@code notes} may be null.
     */
    public static MasteryCheck createFullMarkMC(Student student, LocalDateTime dateAndTime, int lengthOfMeeting,
                                                String placeOfMeeting, String notes) {
        return new MasteryCheck(student, dateAndTime, lengthOfMeeting, placeOfMeeting, notes).setPassed(true);
    }

    /**
     * Creates a {@code MasteryCheck} with zero marks with the given parameters. {@code lengthOfMeeting} and
     * {@code notes} may be null.
     */
    public static MasteryCheck createZeroMarkMC(Student student, LocalDateTime dateAndTime, int lengthOfMeeting,
                                                String placeOfMeeting, String notes) {
        return new MasteryCheck(student, dateAndTime, lengthOfMeeting, placeOfMeeting, notes).setPassed(false);
    }

}
