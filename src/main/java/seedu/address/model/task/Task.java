package seedu.address.model.task;

public abstract class Task {
    private static int taskNum = 1;

    public abstract String generateTaskId();

    public abstract String getDescription();

    public abstract String getTaskId();

    public static int getTaskNum() {
        return taskNum;
    }

    public static void taskNumInc() {
        taskNum++;
    }

    @Override
    public abstract boolean equals(Object other);

    @Override
    public abstract String toString();
}
