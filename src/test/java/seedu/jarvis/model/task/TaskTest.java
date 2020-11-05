package seedu.jarvis.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DATETIME_FIRST;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_FIRST;

import org.junit.jupiter.api.Test;

public class TaskTest {

    private final String TYPE_TODO = "T";
    private final String TYPE_EVENT = "E";
    private final String TYPE_DEADLINE = "D";
    private final Todo todoTest = new Todo(TEST_TASK_DESCRIPTION_FIRST);
    private final Event eventTest = new Event(TEST_TASK_DESCRIPTION_FIRST, TEST_TASK_DATETIME_FIRST);
    private final Deadline deadlineTest = new Deadline(TEST_TASK_DESCRIPTION_FIRST, TEST_TASK_DATETIME_FIRST);

    @Test
    public void taskNumIncTest() {
        int prev = Task.getTaskNum();
        Task.taskNumInc();
        assertEquals(Task.getTaskNum(), prev + 1);
    }

    // Compare task numbers read from .json data file and the current task number stored.
    // And then sets the stored task number based on the larger task number read +1.
    @Test
    // Simulate Todo read from .json data file, new task num == stored task num
    public void compareAndSet_taskNum_todoEqualStored() {
        int storedTaskNum = Task.getTaskNum();
        String simulatedNewTaskId = TYPE_TODO + storedTaskNum;

        Task.compareTaskNum(simulatedNewTaskId);
        int afterComparisonTaskNum = Task.getTaskNum();

        // Ensures that storedTaskNum has an +1 increment
        assertFalse(afterComparisonTaskNum < storedTaskNum);
        assertEquals(afterComparisonTaskNum, storedTaskNum + 1);
    }

    @Test
    // Simulate Todo read from .json data file, new task num > stored task num
    public void compareAndSet_taskNum_todoGreaterStored() {
        int storedTaskNum = Task.getTaskNum();
        int taskNumInc = 100;
        int newTaskNum = storedTaskNum + taskNumInc;
        String simulatedNewTaskId = TYPE_TODO + newTaskNum;

        Task.compareTaskNum(simulatedNewTaskId);
        int afterComparisonTaskNum = Task.getTaskNum();

        assertTrue(afterComparisonTaskNum > storedTaskNum);
        assertEquals(afterComparisonTaskNum, storedTaskNum + taskNumInc + 1);
    }

    @Test
    // Simulate Event read from .json data file, new task num > stored task num
    public void compareAndSet_taskNum_eventGreaterStored() {
        int storedTaskNum = Task.getTaskNum();
        int taskNumInc = 1;
        int newTaskNum = storedTaskNum + taskNumInc;
        String simulatedNewTaskId = TYPE_EVENT + newTaskNum;

        Task.compareTaskNum(simulatedNewTaskId);
        int afterComparisonTaskNum = Task.getTaskNum();

        assertTrue(afterComparisonTaskNum > storedTaskNum);
        assertEquals(afterComparisonTaskNum, storedTaskNum + taskNumInc + 1);
    }

    @Test
    // Simulate Deadline read from .json data file, new task num > stored task num
    public void compareAndSet_taskNum_deadlineGreaterStored() {
        int storedTaskNum = Task.getTaskNum();
        int taskNumInc = 5;
        int newTaskNum = storedTaskNum + taskNumInc;
        String simulatedNewTaskId = TYPE_DEADLINE + newTaskNum;

        Task.compareTaskNum(simulatedNewTaskId);
        int afterComparisonTaskNum = Task.getTaskNum();

        assertTrue(afterComparisonTaskNum > storedTaskNum);
        assertEquals(afterComparisonTaskNum, storedTaskNum + taskNumInc + 1);
    }

    @Test
    // Simulate Event read from .json data file, new task num < stored task num
    public void compareAndSet_taskNum_eventSmallerStored() {
        int storedTaskNum = Task.getTaskNum();
        int taskNumInc = -1;
        int newTaskNum = storedTaskNum + taskNumInc;
        String simulatedNewTaskId = TYPE_EVENT + newTaskNum;

        Task.compareTaskNum(simulatedNewTaskId);
        int afterComparisonTaskNum = Task.getTaskNum();

        assertFalse(afterComparisonTaskNum > storedTaskNum);
        assertEquals(afterComparisonTaskNum, storedTaskNum);
    }

    @Test
    // Simulate Deadline read from .json data file, new task num < stored task num
    public void compareAndSet_taskNum_deadlineSmallerStored() {
        int storedTaskNum = Task.getTaskNum();
        int taskNumInc = -100;
        int newTaskNum = storedTaskNum + taskNumInc;
        String simulatedNewTaskId = TYPE_DEADLINE + newTaskNum;

        Task.compareTaskNum(simulatedNewTaskId);
        int afterComparisonTaskNum = Task.getTaskNum();

        assertFalse(afterComparisonTaskNum > storedTaskNum);
        assertEquals(afterComparisonTaskNum, storedTaskNum);
    }

    @Test
    public void getTypes() {
        assertEquals(Task.getType(todoTest), TYPE_TODO);
        assertEquals(Task.getType(eventTest), TYPE_EVENT);
        assertEquals(Task.getType(deadlineTest), TYPE_DEADLINE);
    }

    @Test
    public void getUnformattedPossibleDateTimeTest() {

    }

}
