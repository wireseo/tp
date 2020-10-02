package seedu.address.model.mission;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MissionList {
    private final ObservableList<Mission> internalList = FXCollections.observableArrayList();

    /**
     * Adds a mission to the list.
     */
    public void add(Mission toAdd) {
        internalList.add(toAdd);
    }

    public void setMissions(List<Mission> missions) {
        this.internalList.setAll(missions);
    }

    public ObservableList<Mission> asObservableList() {
        return internalList;
    }
}
