package seedu.address.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import seedu.address.model.student.Student;

/**
 * Represents a Consultation that contains information relating to general consultations.
 */
public class Consultation {
    private LocalDate dateAndTime;
    private Optional<Integer> lengthOfMeeting;
    private Optional<String> placeOfMeeting;
    private Optional<String> notes;
    private String minutes;

    /**
     * Creates a {@code Consultation} with the given parameters.
     * {@code placeOfMeeting} and {@code notes} may be null.
     * @param dateAndTime date and time of the consultation
     * @param lengthOfMeeting the length of the consultation in minutes
     * @param placeOfMeeting place of meeting; may be a zoom link or any indicator for a meeting room at NUS
     * @param notes any notes relevant to the consultation; may be null
     */
    public Consultation(LocalDate dateAndTime, int lengthOfMeeting, String placeOfMeeting, String notes) {
        this.dateAndTime = dateAndTime;
        this.lengthOfMeeting = Optional.of(lengthOfMeeting);
        this.placeOfMeeting = Optional.of(placeOfMeeting);
        this.notes = Optional.of(notes);
        this.minutes = "";
    }

    public LocalDate getDateAndTime() {
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

    public void setDateAndTime(LocalDate dateAndTime) {
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
        return Objects.hash(dateAndTime, lengthOfMeeting);
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
        return otherConsultation.getDateAndTime().equals(getDateAndTime())
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
        sb.append("Consultation @");
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
