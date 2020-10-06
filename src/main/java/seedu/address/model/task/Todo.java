package seedu.address.model.task;

/**
 * Represents a Todo task.
 */
public class Todo extends Task {

    private final String taskId;
    private final String description;

    /**
     * Creates a Todo object that only has taskId and description attributes.
     * @param description
     */
    public Todo(String description) {
        this.taskId = generateTaskId();
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Returns a unique task id.
     */
    public String generateTaskId() {
        int taskNum = Task.getTaskNum();
        Task.taskNumInc();
        return "T" + taskNum;
    }

    /**
     * Returns true if both tasks have the same task id.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof seedu.address.model.task.Todo)) {
            return false;
        }

        Todo otherTask = (Todo) other;
        return this.taskId.equals(otherTask.getTaskId());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[")
                .append(getTaskId())
                .append("] ")
                .append(getDescription());

        return builder.toString();
    }
}
