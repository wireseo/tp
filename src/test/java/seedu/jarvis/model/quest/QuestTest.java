package seedu.jarvis.model.quest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.jarvis.testutil.TypicalQuests.TEST_QUEST;
import static seedu.jarvis.testutil.TypicalQuests.TEST_QUEST_COPY;
import static seedu.jarvis.testutil.TypicalQuests.TEST_QUEST_DEADLINE;
import static seedu.jarvis.testutil.TypicalQuests.TEST_QUEST_DIFF;
import static seedu.jarvis.testutil.TypicalQuests.TEST_QUEST_TITLE;

import org.junit.jupiter.api.Test;

class QuestTest {

    @Test
    void getTitle() {
        assertTrue(TEST_QUEST.getTitle().equals(TEST_QUEST_TITLE));
    }

    @Test
    void getDeadline() {
        assertTrue(TEST_QUEST.getDeadline().equals(TEST_QUEST_DEADLINE));
    }

    @Test
    void testEquals() {
        // same values -> return true
        assertTrue(TEST_QUEST.equals(TEST_QUEST_COPY));

        // same object -> return true
        assertTrue(TEST_QUEST.equals(TEST_QUEST));

        // null -> returns false
        assertFalse(TEST_QUEST.equals(null));

        // different type -> returns false
        assertFalse(TEST_QUEST.equals(5));

        // different mission -> returns false
        assertFalse(TEST_QUEST.equals(TEST_QUEST_DIFF));
    }

    @Test
    void testToString() {
        String questTestToString = TEST_QUEST.getTitle() + " Deadline: " + TEST_QUEST.getDeadline();
        System.out.println(TEST_QUEST.toString().equals(questTestToString));
    }
}
