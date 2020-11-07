package seedu.jarvis.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.jarvis.storage.JsonAdaptedTask.DATETIME_FIELD;
import static seedu.jarvis.storage.JsonAdaptedTask.DESCRIPTION_FIELD;
import static seedu.jarvis.storage.JsonAdaptedTask.INVALID_DATE_TIME_FORMAT;
import static seedu.jarvis.storage.JsonAdaptedTask.INVALID_TASK_TYPE;
import static seedu.jarvis.storage.JsonAdaptedTask.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.jarvis.storage.JsonAdaptedTask.ID_FIELD;
import static seedu.jarvis.testutil.Assert.assertThrows;
import static seedu.jarvis.testutil.TypicalTasks.DEADLINE4;
import static seedu.jarvis.testutil.TypicalTasks.EVENT4;
import static seedu.jarvis.testutil.TypicalTasks.TODO4;

import org.junit.jupiter.api.Test;

import seedu.jarvis.commons.exceptions.IllegalValueException;

public class JsonAdaptedTaskTest {

    public static String INVALID_DATE = "2019-05-32T20:20";
    public static String INVALID_ID = "A1101";

    public static String VALID_DATE = "2020-02-02T20:20";
    public static String VALID_DESCRIPTION = "Clean the bowl";
    public static String VALID_ID_TODO = "T2000";
    public static String VALID_ID_EVENT = "E777";
    public static String VALID_ID_DEADLINE = "D1101";

    @Test
    public void toModelType_validTodoDetails_returnsTodo() throws Exception {
        JsonAdaptedTask todo = new JsonAdaptedTask(TODO4);
        assertEquals(TODO4, todo.toModelType());

        JsonAdaptedTask event = new JsonAdaptedTask(EVENT4);
        assertEquals(EVENT4, event.toModelType());

        JsonAdaptedTask deadline = new JsonAdaptedTask(DEADLINE4);
        assertEquals(DEADLINE4, deadline.toModelType());
    }

    @Test
    public void toModelType_nullId_throwsIllegalValueException() {
        JsonAdaptedTask task = new JsonAdaptedTask(null, VALID_DESCRIPTION, VALID_DATE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, ID_FIELD);
        assertThrows(IllegalValueException.class, expectedMessage, task::toModelType);
    }

    @Test
    public void toModelType_nullDescription_throwsIllegalValueException() {
        JsonAdaptedTask task = new JsonAdaptedTask(VALID_ID_TODO, null, VALID_DATE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, DESCRIPTION_FIELD);
        assertThrows(IllegalValueException.class, expectedMessage, task::toModelType);
    }

    @Test
    public void toModelType_nullDateTime_throwsIllegalValueException() {
        JsonAdaptedTask task = new JsonAdaptedTask(VALID_ID_TODO, VALID_DESCRIPTION, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, DATETIME_FIELD);
        assertThrows(IllegalValueException.class, expectedMessage, task::toModelType);
    }

    @Test
    public void toModelType_invalidDateTime_throwsIllegalValueException() {
        JsonAdaptedTask event = new JsonAdaptedTask(VALID_ID_EVENT, VALID_DESCRIPTION, INVALID_DATE);
        assertThrows(IllegalValueException.class, INVALID_DATE_TIME_FORMAT, event::toModelType);

        JsonAdaptedTask deadline = new JsonAdaptedTask(VALID_ID_DEADLINE, VALID_DESCRIPTION, INVALID_DATE);
        assertThrows(IllegalValueException.class, INVALID_DATE_TIME_FORMAT, deadline::toModelType);
    }

    @Test
    public void toModelType_invalidTaskType_throwsIllegalValueException() {
        JsonAdaptedTask task = new JsonAdaptedTask(INVALID_ID, VALID_DESCRIPTION, VALID_DATE);
        assertThrows(IllegalValueException.class, INVALID_TASK_TYPE, task::toModelType);
    }

}
