package seedu.address.model.mission;

public class Mission {
    private final String title;
    private final String deadline;

    /**
     * Creates a mission object.
     *
     * @param title
     * @param deadline
     */
    public Mission(String title, String deadline) {
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
     * Returns true if both missions have the same title and deadline.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Mission)) {
            return false;
        }

        Mission otherMission = (Mission) other;
        return otherMission.getTitle().equals(getTitle())
                && otherMission.getDeadline().equals(getDeadline());

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
