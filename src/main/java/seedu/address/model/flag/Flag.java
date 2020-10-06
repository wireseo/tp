package seedu.address.model.flag;

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

import java.util.Set;

import com.google.common.collect.ImmutableSet;

/**
 * Flag class encapsulates the flags, eg: -m, etc, that will appear after a command.
 */
public class Flag {
    public static final String MESSAGE_CONSTRAINTS = "Flag provided is invalid";
    private static final Set<String> VALID_FLAGS = ImmutableSet.of(MISSION_DEADLINE, QUEST_DEADLINE,
            UNGRADED_MISSION_QUEST, MISSION_AND_QUEST_DEADLINE, SPECIFIC_MISSION_QUEST_DEADLINE, VIEW_STUDENT,
            "-s Alex Yeoh", TASK_TODO, TASK_EVENT, TASK_DEADLINE, TASK_DATE, TASK_TIME);

    public final String flag;

    public Flag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return this.flag;
    }

    /**
     * Checks whether given test flag is a valid flag.
     * @param test Flag to be tested
     * @return A Boolean denoting whether the flag is valid
     */
    public static boolean isValidFlag(String test) {
        return VALID_FLAGS.contains(test);
    }
}
