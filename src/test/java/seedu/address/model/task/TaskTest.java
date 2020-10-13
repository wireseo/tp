package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void taskNumInc() {
        int prev = Task.getTaskNum();
        Task.taskNumInc();
        assertTrue(Task.getTaskNum() == prev + 1);
    }
}
