package seedu.address.model.mission;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MissionList {
    private final ObservableList<Mission> internalList = FXCollections.observableArrayList();

    /**
     * Adds a mission to the list.
     */
    public void add(Mission toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    /**
     * Returns true if the list contains an equivalent mission as the given argument.
     */
    public boolean contains(Mission toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::equals);
    }

    public void setMissions(List<Mission> missions) {
        requireNonNull(missions);
        this.internalList.setAll(missions);
    }

    public ObservableList<Mission> asObservableList() {
        return internalList;
    }
}
