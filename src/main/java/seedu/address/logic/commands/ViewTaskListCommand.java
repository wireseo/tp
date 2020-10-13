package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.AddCommand.MESSAGE_SUCCESS_DEADLINE;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_MISSIONS;

import java.util.ArrayList;

import seedu.address.model.Model;
import seedu.address.model.task.Task;

/**
 * Lists all mission deadlines.
 */
public class ViewTaskListCommand extends ViewCommand {

        public static final String MESSAGE_SUCCESS = "Listed all tasks: \n%1$s";

        //Temp storage for visualization
        public static ArrayList<Task> taskList = new ArrayList<>();

        @Override
        public CommandResult execute(Model model) {
            requireNonNull(model);
            String list = parseList();
            return new CommandResult(String.format(MESSAGE_SUCCESS, list));
        }

        //For temp view of storage
        private String parseList() {
            String parsedList = "";
            int size = taskList.size();
            for (int i = 0; i < size; i++) {
                parsedList = parsedList + taskList.get(i).toString() + "\n";
            }
            return parsedList;
        }
}
