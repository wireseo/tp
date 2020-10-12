package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ViewAllStudentsCommand;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.commands.ViewMissionDeadlineCommand;
import seedu.address.logic.commands.ViewOneStudentCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.flag.Flag;
import seedu.address.model.student.Name;
import seedu.address.testutil.TypicalStudents;

public class ViewCommandParserTest {

    /**
     * Test for invalid empty string input
     */
    @Test
    public void parse_emptyStringInput_throwsParseException() {
        ViewCommandParser parser = new ViewCommandParser();
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidCommandFormat_throwsParseException() {
        ViewCommandParser parser = new ViewCommandParser();
        assertParseFailure(parser, "-2", Flag.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_viewMissionDeadline_success() throws ParseException {
        ViewCommandParser parser = new ViewCommandParser();
        Command command = parser.parse("-m");
        assertTrue(command instanceof ViewMissionDeadlineCommand);
    }

    @Test
    public void parse_viewAllStudent_success() throws ParseException {
        ViewCommandParser parser = new ViewCommandParser();
        Command command = parser.parse("-s");
        assertTrue(command instanceof ViewAllStudentsCommand);
    }

    @Test
    public void parse_viewOneStudent_success() throws ParseException {
        ViewCommandParser parser = new ViewCommandParser();
        Name studentName = TypicalStudents.ALICE.getName();
        Command command = parser.parse("-s " + studentName.fullName);
        assertTrue(command instanceof ViewOneStudentCommand);
    }
}
