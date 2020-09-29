package seedu.address.model.mission;

public class Mission {
    private final String title;
    private final String deadline;

    /**
     * Creates a mission object.
     * @param title
     * @param deadline
     */
    public Mission(String title, String deadline) {
        this.title = title;
        this.deadline = deadline;
    }
}
