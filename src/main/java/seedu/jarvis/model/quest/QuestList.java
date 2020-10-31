package seedu.jarvis.model.quest;

import java.util.List;
import java.util.Optional;

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

    public boolean isQuestInList(String name) {
        return internalList.stream().anyMatch(quest -> quest.getTitle().equals(name));
    }

    /**
     * Updates the quest found to be ungraded
     *
     * @param name quest title
     * @return true if quest was found and updated successfully
     */
    public boolean updateQuest(String name) {
        Optional<Quest> questToUpdate = internalList.stream().filter(quest -> quest.getTitle().equals(name))
                .findFirst();
        if (questToUpdate.isPresent()) {
            Quest quest = questToUpdate.get();
            this.internalList.remove(questToUpdate.get());
            quest = quest.setIsGraded(false);
            this.internalList.add(quest);
            return true;
        } else {
            return false;
        }
    }
}
