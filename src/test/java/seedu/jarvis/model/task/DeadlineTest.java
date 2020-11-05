package seedu.jarvis.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.jarvis.testutil.Assert.assertThrows;
import static seedu.jarvis.testutil.TypicalTasks.FORMATTED_DATETIME_ONE;
import static seedu.jarvis.testutil.TypicalTasks.FORMATTED_DATETIME_THREE;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DATETIME_FIRST;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DATETIME_FOURTH;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DATETIME_SECOND;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DATETIME_THIRD;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_FIRST;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_FOURTH;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_SECOND;
import static seedu.jarvis.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_THIRD;

import org.junit.jupiter.api.Test;

public class DeadlineTest {
    private final Deadline deadlineTest = new Deadline(TEST_TASK_DESCRIPTION_FIRST, TEST_TASK_DATETIME_FIRST);
    private final Deadline deadlineTestTwo = new Deadline(TEST_TASK_DESCRIPTION_SECOND, TEST_TASK_DATETIME_SECOND);
    private final Deadline deadlineTestThree = new Deadline(TEST_TASK_DESCRIPTION_THIRD, TEST_TASK_DATETIME_THIRD);
    private final Deadline deadlineTestFour = new Deadline(TEST_TASK_DESCRIPTION_FOURTH, TEST_TASK_DATETIME_FOURTH);

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Deadline(null, null));
        assertThrows(NullPointerException.class, () -> new Deadline(null, TEST_TASK_DATETIME_FIRST));
        assertThrows(NullPointerException.class, () -> new Deadline(TEST_TASK_DESCRIPTION_FIRST, null));
    }

    @Test
    void getDescription() {
        assertTrue(deadlineTestTwo.getDescription().equals(TEST_TASK_DESCRIPTION_SECOND));
        assertFalse(deadlineTestFour.getDescription().equals(TEST_TASK_DESCRIPTION_THIRD));
    }

    @Test
    void getDateTime() {
        assertTrue(deadlineTest.getDateTime().equals(FORMATTED_DATETIME_ONE));
        assertFalse(deadlineTestTwo.getDateTime().equals(FORMATTED_DATETIME_THREE));
    }

    @Test
    void generateTaskIdTest() {
        String deadlineCurrentId = deadlineTest.getTaskId();
        String deadlineNextId = deadlineTest.generateTaskId();
        assertTrue(deadlineCurrentId != deadlineNextId);
    }

    @Test
    void testEquals() {
        //same object reference -> true
        assertTrue(deadlineTest.equals(deadlineTest));

        //different object refernce -> false
        assertFalse(deadlineTestTwo.equals(deadlineTestFour));
    }

    @Test
    void testToString() {
        String taskTestToString = "[" + deadlineTestThree.getTaskId() + "] " + deadlineTestThree.getDescription()
                + " by " + deadlineTestThree.getDateTime();
        assertTrue(deadlineTestThree.toString().equals(taskTestToString));
    }
}
