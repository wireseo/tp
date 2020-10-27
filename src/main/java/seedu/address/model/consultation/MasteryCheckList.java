package seedu.address.model.consultation;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class MasteryCheckList {
    private final ObservableList<MasteryCheck> internalList = FXCollections.observableArrayList();

    /**
     * Adds a mastery check to the list.
     */
    public void add(MasteryCheck toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    /**
     * Returns true if the list contains an equivalent mastery check as the given argument.
     */
    public boolean contains(MasteryCheck toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameConsultation);
    }

    public void setMasteryChecks(List<MasteryCheck> masteryChecks) {
        requireNonNull(masteryChecks);
        this.internalList.setAll(masteryChecks);
    }

    public ObservableList<MasteryCheck> asObservableList() {
        return internalList;
    }

    public boolean isMasteryCheckInList(String name) {
        return internalList.stream().anyMatch(masteryCheck -> masteryCheck.getIdentifier().equals(name));
    }
}
