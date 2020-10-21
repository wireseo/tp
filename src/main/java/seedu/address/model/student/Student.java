package seedu.address.model.student;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import seedu.address.model.Consultation;
import seedu.address.model.tag.Tag;

/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student {

    // Identity fields
    private final Name name;
    private final Telegram telegram;
    private final Email email;

    // Field to be used in the future for editing student participation levels
    private ParticipationLevel participationLevel;
    private List<Consultation> consultations = new ArrayList<>();


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
     * Every field must be present and not null. This constructor contains consultations.
     */
    public Student(Name name, Telegram telegram, Email email, Set<Tag> tags,
                   List<Consultation> consultations) {
        requireAllNonNull(name, telegram, email, tags, consultations);
        this.name = name;
        this.telegram = telegram;
        this.email = email;
        this.consultations.addAll(consultations);
    }

    public Name getName() {
        return name;
    }

    public Telegram getTelegram() {
        return telegram;
    }

    public Email getEmail() {
        return email;
    }

    /**
     * Returns an immutable consultation list, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public List<Consultation> getConsultations() {
        return Collections.unmodifiableList(consultations);
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
                && otherStudent.getEmail().equals(getEmail())
                && otherStudent.getConsultations().equals(getConsultations());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, telegram, email, consultations);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Telegram: ")
                .append(getTelegram())
                .append(" Email: ")
                .append(getEmail())
                .append(" Consultations: ")
                .append(getConsultations())
                .append(" Tags: ");
        return builder.toString();
    }

}
