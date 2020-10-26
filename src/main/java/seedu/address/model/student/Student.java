package seedu.address.model.student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Optional;

import seedu.address.model.consultation.Consultation;

/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student {

    // Identity fields
    private final Name name;
    private final Telegram telegram;
    private final Email email;

    // By default every student has no consultations. However we need to see how consultation is implemented to make
    // sure that upon start up the stored data is reflected.
    private Optional<Consultation> consultation = Optional.empty();

    /**
     * Every field must be present and not null.
     */
    public Student(Name name, Telegram telegram, Email email) {
        requireAllNonNull(name, telegram, email);
        this.name = name;
        this.telegram = telegram;
        this.email = email;
    }

    /**
     * Getter method for the name of the student.
     */
    public Name getName() {
        return name;
    }

    /**
     * Getter method for the telegram username of the student.
     */
    public Telegram getTelegram() {
        return telegram;
    }

    /**
     * Getter method for the email address of the student.
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Assigns a consultation slot to a student.
     * @param consultationSession to be attached to this student.
     */
    public void setConsultation(Consultation consultationSession) {
        requireNonNull(consultationSession);
        consultation = Optional.of(consultationSession);
    }

    /**
     * Getter method for a consultation with the student. If a consultation with this student does not exists,
     * an empty optional will be returned, else an optional with the Consultation session will be returned.
     */
    public Optional<Consultation> getConsultation() {
        return consultation;
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Student otherStudent) {
        if (otherStudent == this) {
            return true;
        }

        return otherStudent != null
                && otherStudent.getName().equals(getName())
                && (otherStudent.getTelegram().equals(getTelegram()) || otherStudent.getEmail().equals(getEmail()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Student)) {
            return false;
        }

        Student otherStudent = (Student) other;
        return otherStudent.getName().equals(getName())
                && otherStudent.getTelegram().equals(getTelegram())
                && otherStudent.getEmail().equals(getEmail());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, telegram, email);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Telegram: ")
                .append(getTelegram())
                .append(" Email: ")
                .append(getEmail());
        return builder.toString();
    }

}
