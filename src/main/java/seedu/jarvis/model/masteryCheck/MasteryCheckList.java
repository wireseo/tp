package seedu.jarvis.model.masteryCheck;

import static java.util.Objects.requireNonNull;
import static seedu.jarvis.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.jarvis.model.masteryCheck.exceptions.DuplicateMasteryCheckException;
import seedu.jarvis.model.masteryCheck.exceptions.MasteryCheckNotFoundException;


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

    public void setMasteryCheck(List<MasteryCheck> masteryChecks) {
        requireNonNull(masteryChecks);
        this.internalList.setAll(masteryChecks);
    }
    public ObservableList<MasteryCheck> asObservableList() {
        return internalList;
    }

    public boolean isMasteryCheckInList(String name) {
        return internalList.stream().anyMatch(masteryCheck -> masteryCheck.getIdentifier().equals(name));
    }

    /**
     * Replaces the student {@code target} in the list with {@code editedStudent}.
     * {@code target} must exist in the list.
     */
    public void setMasteryCheck(MasteryCheck target, MasteryCheck editedMasteryCheck) {
        requireAllNonNull(target, editedMasteryCheck);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new MasteryCheckNotFoundException();
        }

        if (!target.isSameConsultation(editedMasteryCheck) && contains(editedMasteryCheck)) {
            throw new DuplicateMasteryCheckException();
        }

        internalList.set(index, editedMasteryCheck);
    }
}