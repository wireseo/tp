package seedu.address.model.consultation;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import seedu.address.model.student.Student;


/**
 * Represents a Consultation that contains information relating to general consultations.
 */
public class Consultation {
    private Student student;
    private LocalDateTime dateAndTime;
    private Optional<Integer> lengthOfMeeting;
    private Optional<String> placeOfMeeting;
    private Optional<String> notes;

    /**
     * Creates a {@code Consultation} with the given parameters.
     * {@code placeOfMeeting} {@code lengthOfMeeting} and {@code notes} may be null.
     * @param student the subject of this consultation
     * @param dateAndTime date and time of the consultation
     * @param lengthOfMeeting the length of the consultation in minutes
     * @param placeOfMeeting place of meeting; may be a zoom link or any indicator for a meeting room at NUS
     * @param notes any notes relevant to the consultation; may be null
     *
     * Student and dateAndTime are the identifiers of objects of this class.
     */
    public Consultation(Student student, LocalDateTime dateAndTime, int lengthOfMeeting, String placeOfMeeting,
                        String notes) {
        this.student = student; // TODO: NEED TO TEST WHEN STUDENT REFERENCE DELETED IN FILE; AUTO DELETE NECESSARY
        this.dateAndTime = dateAndTime;
        this.lengthOfMeeting = Optional.of(lengthOfMeeting);
        this.placeOfMeeting = Optional.of(placeOfMeeting);
        this.notes = Optional.of(notes);
    }

    public Student getStudent() {
        return student;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public String getIdentifier() {
        return getStudent().getName().fullName + dateAndTime.toString();
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

    // Over here a navigability from student to Consultation is also created, hopefully this wouldnt break.
    /**
     * Sets a student to be the subject of this consultation session and the student to have this consultation session.
     * @param student to be under this consultation session.
     */
    public void setStudent(Student student) {
        this.student = student;
        student.setConsultation(this);
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
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


    @Override
    public int hashCode() {
        return Objects.hash(student, dateAndTime);
    }


    /**
     * Returns true if both consultations have the same identity and data fields, not including the place of meeting.
     */
    public boolean isSameConsultation(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Consultation)) {
            return false;
        }

        Consultation otherConsultation = (Consultation) other;
        return otherConsultation.getStudent().equals(getStudent())
                && otherConsultation.getDateAndTime().equals(getDateAndTime());
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
        sb.append(getStudent().getName().fullName);
        sb.append(" @");
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
