package seedu.address.model.quest;

public class Quest {
    private final String title;
    private final String deadline;
    /**
     * Creates a Quest object.
     *
     * @param title
     * @param deadline
     */
    public Quest(String title, String deadline) {
        this.title = title;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getDeadline() {
        return deadline;
    }

    /**
     * Returns true if both quests have the same title and deadline.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Quest)) {
            return false;
        }

        Quest otherQuest = (Quest) other;
        return otherQuest.getTitle().equals(getTitle())
                && otherQuest.getDeadline().equals(getDeadline());

    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Deadline: ")
                .append(getDeadline());

        return builder.toString();
    }
}

