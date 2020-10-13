package seedu.address.model.mission;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalMissions.TEST_MISSION;
import static seedu.address.testutil.TypicalMissions.TEST_MISSION_DIFF;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MissionListTest {

    private final MissionList missionList = new MissionList();
    private final List<Mission> missionListTest = new ArrayList<>();

    @Test
    void add_nullMission_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> missionList.add(null));
    }

    @Test
    void contains_nullMission_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> missionList.contains(null));
    }

    @Test
    public void contains_missionNotInList_returnsFalse() {
        assertFalse(missionList.contains(TEST_MISSION));
    }

    @Test
    public void contains_missionInList_returnsTrue() {
        missionList.add(TEST_MISSION);
        assertTrue(missionList.contains(TEST_MISSION));
    }

    @Test
    void setNullMission_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> missionList.setMissions(null));
        missionListTest.add(TEST_MISSION_DIFF);
        missionList.setMissions(missionListTest);
        assertFalse(missionList.contains(TEST_MISSION));
    }

    @Test
    void change_missionList_to_asObservableList() {
        assertFalse(missionList.getClass().equals(missionList.asObservableList().getClass()));
    }
}
