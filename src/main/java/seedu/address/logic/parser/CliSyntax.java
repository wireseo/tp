package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_TELEGRAM = new Prefix("t/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");

    /* View Command flags */
    public static final String UNGRADED_MISSION = "-um";
    public static final String UNGRADED_QUEST = "-uq";
    public static final String MISSION_DEADLINE = "-m";
    public static final String QUEST_DEADLINE = "-q";
    public static final String VIEW_STUDENT = "-s";

    /* Add Command flags */
    public static final String TASK_TODO = "-t";
    public static final String TASK_EVENT = "-e";
    public static final String TASK_DEADLINE = "-d";
    public static final String TASK_DATE = "d/";
    public static final String TASK_TIME = "t/";
    public static final String VIEW_TASK_LIST = "-t";

}
