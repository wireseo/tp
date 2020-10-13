package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalTasks.FORMATTED_DATETIME_FOUR;
import static seedu.address.testutil.TypicalTasks.FORMATTED_DATETIME_ONE;
import static seedu.address.testutil.TypicalTasks.FORMATTED_DATETIME_THREE;
import static seedu.address.testutil.TypicalTasks.TEST_TASK_DATETIME_FIRST;
import static seedu.address.testutil.TypicalTasks.TEST_TASK_DATETIME_FOURTH;
import static seedu.address.testutil.TypicalTasks.TEST_TASK_DATETIME_SECOND;
import static seedu.address.testutil.TypicalTasks.TEST_TASK_DATETIME_THIRD;
import static seedu.address.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_FIRST;
import static seedu.address.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_FOURTH;
import static seedu.address.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_SECOND;
import static seedu.address.testutil.TypicalTasks.TEST_TASK_DESCRIPTION_THIRD;

import org.junit.jupiter.api.Test;

class DeadlineTest {
    Deadline deadlineTest = new Deadline(TEST_TASK_DESCRIPTION_FIRST, TEST_TASK_DATETIME_FIRST);
    Deadline deadlineTestTwo = new Deadline(TEST_TASK_DESCRIPTION_SECOND, TEST_TASK_DATETIME_SECOND);
    Deadline deadlineTestThree = new Deadline(TEST_TASK_DESCRIPTION_THIRD, TEST_TASK_DATETIME_THIRD);
    Deadline deadlineTestFour = new Deadline(TEST_TASK_DESCRIPTION_FOURTH, TEST_TASK_DATETIME_FOURTH);

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
