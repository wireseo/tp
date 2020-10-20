package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import seedu.address.model.Model;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Event;
import seedu.address.model.task.Task;
import seedu.address.model.task.Todo;

/**
 * Lists all tasks.
 */
public class ViewTaskListCommand extends ViewCommand {

    public static final String MESSAGE_SUCCESS = "Listed all tasks: \n%1$s";

    //Temp storage for visualization
    private static ArrayList<Task> taskList = new ArrayList<>();

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        String list = parseList();
        return new CommandResult(String.format(MESSAGE_SUCCESS, list));
    }

    //For temp view of storage via the command result feedback box on MainWindow
    private String parseList() {
        String parsedList = "";
        int size = taskList.size();

        for (int i = 0; i < size; i++) {
            parsedList = parsedList + taskList.get(i).toString() + "\n";
        }

        return parsedList;
    }

    public static void add(Todo todo) {
        taskList.add(todo);
    }

    public static void add(Event event) {
        taskList.add(event);
    }

    public static void add(Deadline deadline) {
        taskList.add(deadline);
    }
}
