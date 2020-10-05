package seedu.address.model.flag;

import static seedu.address.logic.parser.CliSyntax.MISSION_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.QUEST_DEADLINE;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class Flag {
    public static final String MESSAGE_CONSTRAINTS = "Flag provided is invalid";
    private static final Set<String> VALID_FLAGS = ImmutableSet.of(MISSION_DEADLINE, QUEST_DEADLINE);
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
