package seedu.address.model.task;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UniqueTasksList {
    private final ObservableList<Task> internalList = FXCollections.observableArrayList();

    /**
     * Adds a mission to the list.
     */
    public void add(Task toAdd) {
        internalList.add(toAdd);
    }

    public void setMissions(List<Task> tasks) {
        this.internalList.setAll(tasks);
    }

    public ObservableList<Task> asObservableList() {
        return internalList;
    }

    /**
     * Returns true if the list contains an equivalent student as the given argument.
     */
    public boolean contains(Task toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::equals);
    }
}
