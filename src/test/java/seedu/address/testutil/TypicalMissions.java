package seedu.address.testutil;

import seedu.address.model.mission.Mission;

/**
 * A utility class containing a list of {@code Mission} objects to be used in tests.
 */
public class TypicalMissions {
    public static final String TEST_MISSION_TITLE = "Fractal Dimensions";
    public static final String TEST_MISSION_DEADLINE = "26-08-2020";
    public static final Mission TEST_MISSION = new Mission(TEST_MISSION_TITLE, TEST_MISSION_DEADLINE);

    public static final Mission TEST_MISSION_COPY = new Mission(TEST_MISSION_TITLE, TEST_MISSION_DEADLINE);

    public static final String TEST_MISSION_TITLE_DIFF = "Musical Notes";
    public static final String TEST_MISSION_DEADLINE_DIFF = "12-10-2020";
    public static final Mission TEST_MISSION_DIFF = new Mission(TEST_MISSION_TITLE_DIFF, TEST_MISSION_DEADLINE_DIFF);
}
