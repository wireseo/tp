package seedu.address.model;

import java.sql.Time;

import seedu.address.model.student.Student;

public class MasteryCheck extends Consultation {

    /**
     * Creates a {@code MasteryCheck} with the given parameters. {@code lengthOfMeeting} and {@code notes} may be null.
     *
     * @param student         student that has requested the consultation
     * @param dateAndTime     date and time of the consultation
     * @param lengthOfMeeting the length of the consultation in minutes; may be null
     * @param placeOfMeeting  place of meeting; may be a zoom link or any indicator for a meeting room at NUS
     * @param notes           any notes relevant to the consultation; may be null
     */
    public MasteryCheck(Student student, Time dateAndTime, int lengthOfMeeting, String placeOfMeeting, String notes) {
        super(student, dateAndTime, lengthOfMeeting, placeOfMeeting, notes);
    }
}
