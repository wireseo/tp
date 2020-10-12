package seedu.address.model.mission;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.TypicalMissions.TEST_MISSION;
import static seedu.address.testutil.TypicalMissions.TEST_MISSION_COPY;
import static seedu.address.testutil.TypicalMissions.TEST_MISSION_DEADLINE;
import static seedu.address.testutil.TypicalMissions.TEST_MISSION_DIFF;
import static seedu.address.testutil.TypicalMissions.TEST_MISSION_TITLE;
import static seedu.address.testutil.TypicalStudents.ALICE;
import static seedu.address.testutil.TypicalStudents.BOB;

import org.junit.jupiter.api.Test;

class MissionTest {

    @Test
    void getTitle() {
        assertTrue(TEST_MISSION.getTitle().equals(TEST_MISSION_TITLE));
    }

    @Test
    void getDeadline() {
        assertTrue(TEST_MISSION.getDeadline().equals(TEST_MISSION_DEADLINE));
    }

    @Test
    void testEquals() {
        // same values -> return true
        assertTrue(TEST_MISSION.equals(TEST_MISSION_COPY));

        // same object -> return true
        assertTrue(TEST_MISSION.equals(TEST_MISSION));

        // null -> returns false
        assertFalse(TEST_MISSION.equals(null));

        // different type -> returns false
        assertFalse(TEST_MISSION.equals(5));

        // different mission -> returns false
        assertFalse(TEST_MISSION.equals(TEST_MISSION_DIFF));
    }

    @Test
    void testToString() {
        String missionTestToString = TEST_MISSION.getTitle() + " Deadline: " + TEST_MISSION.getDeadline();
        System.out.println(TEST_MISSION.toString().equals(missionTestToString));
    }
}