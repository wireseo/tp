package seedu.jarvis.model.task;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void taskNumInc() {
        int prev = Task.getTaskNum();
        Task.taskNumInc();
        assertTrue(Task.getTaskNum() == prev + 1);
    }
}
