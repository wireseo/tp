package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    /* View Command flags */
    public static final String UNGRADED_MISSION_QUEST = "-u";
    public static final String MISSION_DEADLINE = "-m";
    public static final String QUEST_DEADLINE = "-q";
    public static final String MISSION_AND_QUEST_DEADLINE = "-b";
    public static final String SPECIFIC_MISSION_QUEST_DEADLINE = "-i";
    public static final String VIEW_STUDENT = "-s";

    /* Add Command flags */
    public static final String TASK_TODO = "-t";
    public static final String TASK_EVENT = "-e";
    public static final String TASK_DEADLINE = "-d";
    public static final String TASK_DAY = "d/";
    public static final String TASK_TIME = "t/";

}
