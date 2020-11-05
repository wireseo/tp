package seedu.jarvis.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.jarvis.testutil.Assert.assertThrows;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_FIRST;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_FOURTH;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_SECOND;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_THIRD;

import org.junit.jupiter.api.Test;

public class TodoTest {
    private final Todo todoTest = new Todo(TEST_TASK_DESCRIPTION_FIRST);
    private final Todo todoTestTwo = new Todo(TEST_TASK_DESCRIPTION_SECOND);
    private final Todo todoTestThree = new Todo(TEST_TASK_DESCRIPTION_THIRD);
    private final Todo todoTestFour = new Todo(TEST_TASK_DESCRIPTION_FOURTH);

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Todo(null));
    }

    @Test
    void getDescription() {
        assertTrue(todoTest.getDescription().equals(TEST_TASK_DESCRIPTION_FIRST));
        assertFalse(todoTestThree.getDescription().equals(TEST_TASK_DESCRIPTION_FOURTH));
    }

    @Test
    void generateTaskIdTest() {
        String todoCurrentId = todoTest.getTaskId();
        String todoNextId = todoTest.generateTaskId();
        assertTrue(todoCurrentId != todoNextId);
    }

    @Test
    void testEquals() {
        //same object reference -> true
        assertTrue(todoTest.equals(todoTest));

        //different object refernce -> false
        assertFalse(todoTestTwo.equals(todoTestFour));
    }

    @Test
    void testToString() {
        String taskTestToString = "[" + todoTestThree.getTaskId() + "] " + todoTestThree.getDescription();
        assertTrue(todoTestThree.toString().equals(taskTestToString));
    }
}
