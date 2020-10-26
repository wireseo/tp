package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.VIEW_DEADLINE_LIST;
import static seedu.address.logic.parser.CliSyntax.VIEW_EVENT_LIST;
import static seedu.address.logic.parser.CliSyntax.VIEW_TASK_LIST;
import static seedu.address.logic.parser.CliSyntax.VIEW_TODO_LIST;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.task.Task;

/**
 * Lists all tasks.
 */
public class ViewTaskListCommand extends ViewCommand {
    public static final String SAMPLE_COMMAND_TASK = "view -t";
    public static final String SAMPLE_COMMAND_TODO = "view -tt";
    public static final String SAMPLE_COMMAND_EVENT = "view -te";
    public static final String SAMPLE_COMMAND_DEADLINE = "view -td";
    public static final String MESSAGE_SUCCESS = "Listed all %1$s";
    public static final String TASK_LIST = "tasks";
    public static final String TODO_LIST = "todos";
    public static final String EVENT_LIST = "events";
    public static final String DEADLINE_LIST = "deadlines";

    private final String viewType;

    public ViewTaskListCommand(String viewType) {
        this.viewType = viewType;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        //Temp storage for visualization
        List<Task> taskList = model.getFilteredTaskList();
        int size = taskList.size();

        switch(viewType) {
        case VIEW_TASK_LIST:
            /*
            model.updateFilteredTaskList(Model.PREDICATE_SHOW_ALL_TASKS);
            return new CommandResult(MESSAGE_SUCCESS, TASK_LIST);
            */

            //Temp method
            String listTask = "tasks:\n";
            String list = parseList(taskList, listTask);
            return new CommandResult(String.format(MESSAGE_SUCCESS, list));

        case VIEW_TODO_LIST:
            /*
            model.updateFilteredTaskList(Model.PREDICATE_SHOW_ALL_TODOS);
            return new CommandResult(MESSAGE_SUCCESS, TODO_LIST);
            */

            //Temp method
            ArrayList<Task> copyListTodo = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Task currTask = taskList.get(i);
                if (isTodo(currTask)) {
                    copyListTodo.add(currTask);
                }
            }

            String listTodo = "todos:\n";
            String todoList = parseList(copyListTodo, listTodo);
            return new CommandResult(String.format(MESSAGE_SUCCESS, todoList));

        case VIEW_EVENT_LIST:
            /*
            model.updateFilteredTaskList(Model.PREDICATE_SHOW_ALL_EVENTS);
            return new CommandResult(MESSAGE_SUCCESS, EVENT_LIST);
            */

            //Temp method
            ArrayList<Task> copyListEvent = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Task currTask = taskList.get(i);
                if (isEvent(currTask)) {
                    copyListEvent.add(currTask);
                }
            }

            String listEvent = "events:\n";
            String eventList = parseList(copyListEvent, listEvent);
            return new CommandResult(String.format(MESSAGE_SUCCESS, eventList));

        case VIEW_DEADLINE_LIST:
            /*
            model.updateFilteredTaskList(Model.PREDICATE_SHOW_ALL_DEADLINES);
            return new CommandResult(MESSAGE_SUCCESS, DEADLINE_LIST);
            */

            //Temp method
            ArrayList<Task> copyListDeadline = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Task currTask = taskList.get(i);
                if (isDeadline(currTask)) {
                    copyListDeadline.add(currTask);
                }
            }

            String listDeadline = "deadlines:\n";
            String deadlineList = parseList(copyListDeadline, listDeadline);
            return new CommandResult(String.format(MESSAGE_SUCCESS, deadlineList));

        default:
            throw new CommandException(Messages.MESSAGE_VIEW_TYPE_NOT_FOUND);
        }
    }

    //Checks if task is a todo.
    private boolean isTodo(Task task) {
        String taskType = Task.getType(task);
        return taskType.equals("T");
    }

    //Checks if task is a event.
    private boolean isEvent(Task task) {
        String taskType = Task.getType(task);
        return taskType.equals("E");
    }

    //Checks if task is a deadline.
    private boolean isDeadline(Task task) {
        String taskType = Task.getType(task);
        return taskType.equals("D");
    }

    //For temp view of storage via the command result feedback box on MainWindow
    private String parseList(List<Task> list, String listType) {
        String parsedList = listType;
        int size = list.size();

        if (size <= 0) {

        } else {
            for (int i = 0; i < size; i++) {
                parsedList = parsedList + list.get(i).toString() + "\n";
            }
        }

        return parsedList;
    }
}
