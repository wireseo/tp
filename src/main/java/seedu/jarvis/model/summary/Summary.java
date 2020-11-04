package seedu.jarvis.model.summary;

import java.util.HashMap;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Summary {

    // The following strings are the keys for the summary values.
    public static final String UNGRADED_MISSIONS = "Ungraded Missions";
    public static final String UNGRADED_QUESTS = "Ungraded Quests";
    public static final String UPCOMING_CONSULTATIONS = "Upcoming Consultations";
    public static final String UPCOMING_MASTERY_CHECKS = "Upcoming Mastery Checks";
    public static final String TASKS = "Outstanding Tasks";

    // an always updated hash map of summary values.
    private HashMap<String, Integer> summaryHashMap = new HashMap<>();

    private StringProperty summaryDetails = new SimpleStringProperty();

    /**
     * Creates an instance of Summary object, with all summary values set to 0.
     */
    public Summary() {
        summaryHashMap.put(UNGRADED_MISSIONS, 0);
        summaryHashMap.put(UNGRADED_QUESTS, 0);
        summaryHashMap.put(UPCOMING_CONSULTATIONS, 0);
        summaryHashMap.put(UPCOMING_MASTERY_CHECKS, 0);
        summaryHashMap.put(TASKS, 0);
        formatSummaryString();
    }

    /**
     * Sets the number of ungraded missions, when the hashMap has an existing value.
     * @param numUm
     */
    public void setNumUngradedMissions(int numUm) {
        assert numUm >= 0 : "Trying to set a negative number of ungraded missions";
        summaryHashMap.replace(UNGRADED_MISSIONS, numUm);
    }

    public int getNumUngradedMissions() {
        Integer numUngradedMissions = summaryHashMap.get(UNGRADED_MISSIONS);
        assert numUngradedMissions >= 0 : "Number of ungraded missions is negative";
        return numUngradedMissions;
    }

    /**
     * Sets the number of ungraded quests, when the hashMap has an existing value.
     * @param numUq
     */
    public void setNumUngradedQuests(int numUq) {
        assert numUq >= 0 : "Trying to set a negative number of ungraded quests";
        summaryHashMap.replace(UNGRADED_QUESTS, numUq);
    }

    public int getNumUngradedQuests() {
        Integer numUngradedQuests = summaryHashMap.get(UNGRADED_QUESTS);
        assert numUngradedQuests >= 0 : "Number of ungraded quests is negative";
        return numUngradedQuests;
    }

    /**
     * Sets the number of upcoming Consultations, when the hashMap has an existing value.
     * @param numConsult
     */
    public void setNumUpcomingConsultations(int numConsult) {
        assert numConsult >= 0 : "Trying to set a negative number of consultations";
        summaryHashMap.replace(UPCOMING_CONSULTATIONS, numConsult);
    }

    public int getNumUpcomingConsultations() {
        Integer numConsultations = summaryHashMap.get(UPCOMING_CONSULTATIONS);
        assert numConsultations >= 0 : "Number of consultations is negative";
        return numConsultations;
    }

    /**
     * Sets the number of Mastery Checks, when the hashMap has an existing value.
     * @param numMc
     */
    public void setNumUpcomingMasteryChecks(int numMc) {
        assert numMc >= 0 : "Trying to set a negative number of mastery checks";
        summaryHashMap.replace(UPCOMING_MASTERY_CHECKS, numMc);
    }

    public int getNumUpcomingMasteryChecks() {
        Integer numMasteryChecks = summaryHashMap.get(UPCOMING_MASTERY_CHECKS);
        assert numMasteryChecks >= 0 : "Number of mastery checks is negative";
        return numMasteryChecks;
    }

    /**
     * Sets the number of Tasks, when the hashMap has an existing value.
     * @param numT
     */
    public void setNumTasks(int numT) {
        assert numT >= 0 : "Trying to set a negative number of tasks";
        summaryHashMap.replace(TASKS, numT);
    }

    public int getNumTasks() {
        Integer numTasks = summaryHashMap.get(TASKS);
        assert numTasks >= 0 : "Number of tasks is negative";
        return numTasks;
    }

    /**
     * Updates the summary string, allowing the updates done by the setter methods above to be reflected.
     */
    private void formatSummaryString() {
        StringBuilder summary = new StringBuilder();
        int numUngradedMissions = getNumUngradedMissions();
        int numUngradedQuests = getNumUngradedQuests();
        int numUpcomingConsultations = getNumUpcomingConsultations();
        int numUpcomingMasteryChecks = getNumUpcomingMasteryChecks();
        int numTasks = getNumTasks();

        if (numUngradedMissions > 0) {
            summary.append(UNGRADED_MISSIONS).append(": ").append(numUngradedMissions).append(", ");
        }

        if (numUngradedQuests > 0) {
            summary.append(UNGRADED_QUESTS).append(": ").append(numUngradedQuests).append(", ");
        }

        if (numUpcomingConsultations > 0) {
            summary.append(UPCOMING_CONSULTATIONS).append(": ").append(numUpcomingConsultations).append(", ");
        }

        if (numUpcomingMasteryChecks > 0) {
            summary.append(UPCOMING_MASTERY_CHECKS).append(": ").append(numUpcomingMasteryChecks).append(", ");
        }

        if (numTasks > 0) {
            summary.append(TASKS).append(": ").append(numTasks);
        }

        summaryDetails.setValue(summary.toString());
    }

    public boolean isEmpty() {
        return summaryHashMap == null || summaryDetails.getValue().isEmpty();
    }

    public StringProperty getSummaryDetails() {
        formatSummaryString();
        assert summaryDetails.isNotNull().get() : "summaryDetails is null";
        return summaryDetails;
    }

    @Override
    public String toString() {
        formatSummaryString();
        assert summaryDetails.isNotNull().get() : "summaryDetails is null";
        return summaryDetails.getValue();
    }

}
