package seedu.address.model.flag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.MISSION_AND_QUEST_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.MISSION_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.QUEST_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.SPECIFIC_MISSION_QUEST_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.TASK_DATE;
import static seedu.address.logic.parser.CliSyntax.TASK_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.TASK_EVENT;
import static seedu.address.logic.parser.CliSyntax.TASK_TIME;
import static seedu.address.logic.parser.CliSyntax.TASK_TODO;
import static seedu.address.logic.parser.CliSyntax.UNGRADED_MISSION_QUEST;
import static seedu.address.logic.parser.CliSyntax.VIEW_STUDENT;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableSet;

import seedu.address.model.student.Name;

class FlagTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Flag(null));
    }

    @Test
    public void constructor_invalidFlag_throwsIllegalArgumentException() {
        String invalidFlag = "";
        String invalidFlagName = "-1";
        assertThrows(IllegalArgumentException.class, () -> new Flag(invalidFlag));
        assertThrows(IllegalArgumentException.class, () -> new Flag(invalidFlagName));
    }

    @Test
    void getFlag() {
        assertTrue(MISSION_DEADLINE.equals(new Flag(MISSION_DEADLINE).getFlag()));

        // flag creation will not accept invalid flags.
        String RandomFlag = "RandomFlag";
        assertThrows(IllegalArgumentException.class, () -> new Flag("RandomFlag").getFlag());
    }

    @Test
    void isValidFlag() {
        assertFalse(Flag.isValidFlag(""));
        assertFalse(Flag.isValidFlag("FLAG_NOT_INCLUDED"));

        // Flags in VALID_FLAG set is valid
        assertTrue(Flag.isValidFlag(MISSION_DEADLINE));
        assertTrue(Flag.isValidFlag(QUEST_DEADLINE));
        assertTrue(Flag.isValidFlag(UNGRADED_MISSION_QUEST));
        assertTrue(Flag.isValidFlag(MISSION_AND_QUEST_DEADLINE));
        assertTrue(Flag.isValidFlag(SPECIFIC_MISSION_QUEST_DEADLINE));
        assertTrue(Flag.isValidFlag(VIEW_STUDENT));
        assertTrue(Flag.isValidFlag(TASK_TODO));
        assertTrue(Flag.isValidFlag(TASK_EVENT));
        assertTrue(Flag.isValidFlag(TASK_DEADLINE));
        assertTrue(Flag.isValidFlag(TASK_DATE));
        assertTrue(Flag.isValidFlag(TASK_TIME));
    }
}