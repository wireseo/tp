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
        String type = task.getTaskId().substring(0, 1);

        if (type.equals(TO_ADD_EVENT)) {
            Event taskEvent = (Event)task;
            return taskEvent.getDateTime().toString();

        } else if (type.equals(TO_ADD_DEADLINE)) {
            Deadline taskDeadline = (Deadline)task;
            return taskDeadline.getDateTime().toString();

        } else { // all other task types have no date time attributes
            return "-";
        }
    }

    @Override
    public abstract boolean equals(Object other);

    @Override
    public abstract String toString();
}
