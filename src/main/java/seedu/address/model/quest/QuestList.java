package seedu.address.model.quest;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QuestList {
    private final ObservableList<Quest> internalList = FXCollections.observableArrayList();

    /**
     * Adds a Quest to the list.
     */
    public void add(Quest toAdd) {
        internalList.add(toAdd);
    }

    public void setQuests(List<Quest> quests) {
        this.internalList.setAll(quests);
    }

    public ObservableList<Quest> asObservableList() {
        return internalList;
    }
}
