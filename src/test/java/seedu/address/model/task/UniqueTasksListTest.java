package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalTasks.TEST_DEADLINE;
import static seedu.address.testutil.TypicalTasks.TEST_EVENT;
import static seedu.address.testutil.TypicalTasks.TEST_TODO;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UniqueTasksListTest {

    private final UniqueTasksList taskList = new UniqueTasksList();
    private final List<Task> taskListTest = new ArrayList<>();

    @Test
    void add_nullTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> taskList.add(null));
    }

    @Test
    void contains_nullMission_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> taskList.contains(null));
    }

    @Test
    public void contains_tasksNotInList_returnsFalse() {
        assertFalse(taskList.contains(TEST_TODO));
    }

    @Test
    public void contains_taskInList_returnsTrue() {
        taskList.add(TEST_EVENT);
        assertTrue(taskList.contains(TEST_EVENT));
    }

    @Test
    void setNullTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> taskList.setTasks(null));
        taskListTest.add(TEST_DEADLINE);
        taskList.setTasks(taskListTest);
        assertFalse(taskList.contains(TEST_EVENT));
    }

    @Test
    void change_taskList_to_asObservableList() {
        assertFalse(taskList.getClass().equals(taskList.asObservableList().getClass()));
    }
}
