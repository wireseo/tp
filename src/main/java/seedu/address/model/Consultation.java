package seedu.address.model;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import seedu.address.model.student.Student;

/**
 * Represents a Consultation that contains information relating to general consultations.
 */
public class Consultation {
    private Student student;
    private Date dateAndTime;
    private Optional<Integer> lengthOfMeeting;
    private Optional<String> placeOfMeeting;
    private Optional<String> notes;
    private String minutes;

    /**
     * Creates a {@code Consultation} with the given parameters.
     * {@code lengthOfMeeting}, {@code placeOfMeeting} and {@code notes} may be null.
     * @param student student that has requested the consultation
     * @param dateAndTime date and time of the consultation
     * @param lengthOfMeeting the length of the consultation in minutes; may be null
     * @param placeOfMeeting place of meeting; may be a zoom link or any indicator for a meeting room at NUS
     * @param notes any notes relevant to the consultation; may be null
     */
    public Consultation(Student student, Date dateAndTime, int lengthOfMeeting, String placeOfMeeting, String notes) {
        this.student = student;
        this.dateAndTime = dateAndTime;
        this.lengthOfMeeting = Optional.of(lengthOfMeeting);
        this.placeOfMeeting = Optional.of(placeOfMeeting);
        this.notes = Optional.of(notes);
        this.minutes = "";
    }

    public Student getStudent() {
        return student;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public Optional<Integer> getLengthOfMeeting() {
        return lengthOfMeeting;
    }

    public Optional<String> getPlaceOfMeeting() {
        return placeOfMeeting;
    }

    public Optional<String> getNotes() {
        return notes;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setLengthOfMeeting(Optional<Integer> lengthOfMeeting) {
        this.lengthOfMeeting = lengthOfMeeting;
    }

    public void setPlaceOfMeeting(Optional<String> placeOfMeeting) {
        this.placeOfMeeting = placeOfMeeting;
    }

    public void setNotes(Optional<String> notes) {
        this.notes = notes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }


    @Override
    public int hashCode() {
        return Objects.hash(student, dateAndTime, lengthOfMeeting);
    }

    /**
     * Returns true if both consultations have the same identity and data fields, including the place of meeting.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Consultation)) {
            return false;
        }

        Consultation otherConsultation = (Consultation) other;
        return otherConsultation.getStudent().equals(getStudent())
                && otherConsultation.getDateAndTime().equals(getDateAndTime())
                && otherConsultation.getLengthOfMeeting().equals(getLengthOfMeeting())
                && otherConsultation.getPlaceOfMeeting().equals(getPlaceOfMeeting());
    }

    /**
     * Returns true if both consultations occur at the same date and time.
     */
    public boolean conflictsWith(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Consultation)) {
            return false;
        }

        Consultation otherConsultation = (Consultation) other;
        return otherConsultation.getDateAndTime().equals(getDateAndTime());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Consultation with ");
        sb.append(getStudent().getName());
        sb.append(" @ ");
        sb.append(getDateAndTime());
        sb.append(" for ");
        sb.append(getLengthOfMeeting());
        sb.append(" minutes");
        sb.append(" / ");
        sb.append(getPlaceOfMeeting());
        // may include if checks for optional fields later
        // should add notes and minutes to toString method?
        return sb.toString();
    }
}
