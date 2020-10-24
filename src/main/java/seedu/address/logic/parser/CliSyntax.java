package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_TELEGRAM = new Prefix("t/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_USERNAME = new Prefix("u/");
    public static final Prefix PREFIX_PASSWORD = new Prefix("p/");

    /* Edit Command flags */
    public static final String EDIT_STUDENT = "-s";
    public static final String EDIT_LOGIN = "-l";

    /* View Command flags */
    public static final String UNGRADED_MISSION = "-um";
    public static final String UNGRADED_QUEST = "-uq";
    public static final String MISSION_DEADLINE = "-m";
    public static final String QUEST_DEADLINE = "-q";
    public static final String VIEW_STUDENT = "-s";
    public static final String VIEW_TASK_LIST = "-t";
    public static final String VIEW_TODO_LIST = "-tt";
    public static final String VIEW_EVENT_LIST = "-te";
    public static final String VIEW_DEADLINE_LIST = "-td";

    /* Add Command flags */
    public static final String TASK_TODO = "-t";
    public static final String TASK_EVENT = "-e";
    public static final String TASK_DEADLINE = "-d";
    public static final String TASK_DATE = "d/";
    public static final String TASK_TIME = "t/";

    /* Delete Command flags */
    public static final String DELETE_TASK = "-t";

}
