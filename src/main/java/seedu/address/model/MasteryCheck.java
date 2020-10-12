package seedu.address.model;

import java.time.LocalDate;


public class MasteryCheck extends Consultation {
    private int mark;

    /**
     * Creates a {@code MasteryCheck} with the given parameters. {@code lengthOfMeeting} and {@code notes} may be null.
     *
     * @param dateAndTime     date and time of the consultation
     * @param lengthOfMeeting the length of the consultation in minutes; may be null
     * @param placeOfMeeting  place of meeting; may be a zoom link or any indicator for a meeting room at NUS
     * @param notes           any notes relevant to the consultation; may be null
     */
    private MasteryCheck(LocalDate dateAndTime, int lengthOfMeeting, String placeOfMeeting, String notes) {
        super(dateAndTime, lengthOfMeeting, placeOfMeeting, notes);
    }

    public int getMark() {
        return mark;
    }

    public MasteryCheck setMark(int mark) {
        this.mark = mark;
        return null;
    }

    /**
     * Creates a {@code MasteryCheck} with a full mark with the given parameters. {@code lengthOfMeeting} and
     * {@code notes} may be null.
     */
    public static MasteryCheck createFullMarkMC(LocalDate dateAndTime, int lengthOfMeeting, String placeOfMeeting,
                                                String notes) {
        return new MasteryCheck(dateAndTime, lengthOfMeeting, placeOfMeeting, notes).setMark(1);
    }

    /**
     * Creates a {@code MasteryCheck} with zero marks with the given parameters. {@code lengthOfMeeting} and
     * {@code notes} may be null.
     */
    public static MasteryCheck createZeroMarkMC(LocalDate dateAndTime, int lengthOfMeeting, String placeOfMeeting,
                                                String notes) {
        return new MasteryCheck(dateAndTime, lengthOfMeeting, placeOfMeeting, notes).setMark(0);
    }

}
