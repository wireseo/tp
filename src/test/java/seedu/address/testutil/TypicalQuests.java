package seedu.address.testutil;

import seedu.address.model.quest.Quest;

/**
 * A utility class containing a list of {@code Quest} objects to be used in tests.
 */
public class TypicalQuests {
    public static final String TEST_QUEST_TITLE = "Fractal Dimensions";
    public static final String TEST_QUEST_DEADLINE = "Due: 26th August, 23:59";
    public static final Quest TEST_QUEST = new Quest(TEST_QUEST_TITLE, TEST_QUEST_DEADLINE);

    public static final Quest TEST_QUEST_COPY = new Quest(TEST_QUEST_TITLE, TEST_QUEST_DEADLINE);

    public static final String TEST_QUEST_TITLE_DIFF = "Musical Notes";
    public static final String TEST_QUEST_DEADLINE_DIFF = "Due: 12th October, 23:59";
    public static final Quest TEST_QUEST_DIFF = new Quest(TEST_QUEST_TITLE_DIFF, TEST_QUEST_DEADLINE_DIFF);
}

