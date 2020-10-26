package seedu.address.model.consultation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.student.Student;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class ConsultationList {
    private final ObservableList<Consultation> internalList = FXCollections.observableArrayList();

    /**
     * Adds a consultation to the list.
     */
    public void add(Consultation toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    /**
     * Returns true if the list contains an equivalent consultation as the given argument.
     */
    public boolean contains(Consultation toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::equals);
    }

    public void setConsultations(List<Consultation> consultations) {
        requireNonNull(consultations);
        this.internalList.setAll(consultations);
    }

    public ObservableList<Consultation> asObservableList() {
        return internalList;
    }

    public boolean isConsultationInList(Student student) { // TODO: may be unnecessary
        return internalList.stream().anyMatch(consultation -> consultation.getStudent().equals(student));
    }

    public boolean isConsultationInList(LocalDateTime dateAndTime) { // TODO: may be unnecessary
        return internalList.stream().anyMatch(consultation -> consultation.getDateAndTime().equals(dateAndTime));
    }

    public boolean containsConsultation(Consultation consultation) { // TODO: may be unnecessary
        return internalList.stream().anyMatch(c -> c.isSameConsultation(consultation));
    }

    public void addConsultation(Consultation consultation) {
        this.internalList.add(consultation);
    }
}
