package seedu.address.model.task;

import static seedu.address.logic.commands.AddCommand.TO_ADD_DEADLINE;
import static seedu.address.logic.commands.AddCommand.TO_ADD_EVENT;

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

    public String getPossibleDateTime(Task task) {
        String type = getType(task);

        if (type.equals(TO_ADD_EVENT)) {
            Event taskEvent = (Event) task;
            return taskEvent.getUnformattedDateTime();

        } else if (type.equals(TO_ADD_DEADLINE)) {
            Deadline taskDeadline = (Deadline) task;
            return taskDeadline.getUnformattedDateTime();

        } else { // all other task types have no date time attributes
            return "-";
        }
    }

    public static String getType(Task task) {
        return task.getTaskId().substring(0, 1);
    }

    private static void setTaskCount(int count) {
        taskNum = count;
    }

    /**
     * Compares tasknum from taskid of a task to current tasknum in Task.
     * @param taskId String
     */
    public static void compareTaskNum(String taskId) {
        int taskNum = Integer.parseInt(taskId.substring(1));
        if (taskNum >= Task.getTaskNum()) {
            Task.setTaskCount(taskNum);
            Task.taskNumInc();
        }
    }

    @Override
    public abstract boolean equals(Object other);

    @Override
    public abstract String toString();
}
