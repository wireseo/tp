package seedu.jarvis.logic.parser;

import static seedu.jarvis.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.jarvis.logic.commands.CommandTestUtil.CONSULTATION_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.DATE_DESC_AMY_CONSULTATION;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_DATE_EIGHT_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_DATE_FIVE_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_DATE_FOUR_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_DATE_ONE_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_DATE_SEVEN_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_DATE_SIX_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_DATE_THREE_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_DATE_TWO_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_TIME_FOUR_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_TIME_ONE_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_TIME_THREE_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.INVALID_TIME_TWO_WITH_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.MASTERY_CHECK_PREFIX;
import static seedu.jarvis.logic.commands.CommandTestUtil.NAME_DESC_AMY_CONSULTATION;
import static seedu.jarvis.logic.commands.CommandTestUtil.TIME_DESC_AMY_CONSULTATION;
import static seedu.jarvis.logic.commands.CommandTestUtil.VALID_DATE_AMY_CONSULTATION;
import static seedu.jarvis.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.jarvis.logic.commands.CommandTestUtil.VALID_TIME_AMY_CONSULTATION;
import static seedu.jarvis.logic.commands.add.AddCommand.MESSAGE_MISSING_INFO;
import static seedu.jarvis.logic.commands.add.AddCommand.MESSAGE_WRONG_DATETIME_FORMAT;
import static seedu.jarvis.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.jarvis.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import seedu.jarvis.logic.commands.add.AddCommand;
import seedu.jarvis.logic.commands.add.AddConsultationCommand;
import seedu.jarvis.logic.commands.add.AddMasteryCheckCommand;
import seedu.jarvis.model.consultation.Consultation;
import seedu.jarvis.model.masterycheck.MasteryCheck;

public class AddCommandParserTest {
    private static final String PREAMBLE_NON_EMPTY = "asdfasdf";

    private AddCommandParser parser = new AddCommandParser();

    /**
     * Test for invalid empty string input
     */
    @Test
    public void parse_emptyStringInput_throwsParseException() {
        assertParseFailure(parser, "", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddCommand.MESSAGE_ADD_USAGE));
    }

    @Test
    public void parse_invalidCommandFormat_throwsParseException() {
        assertParseFailure(parser, "-2", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddCommand.MESSAGE_ADD_USAGE));
    }

    @Test
    public void parseConsultation_allFieldsPresent_success() {
        LocalDateTime t = LocalDateTime.parse(VALID_DATE_AMY_CONSULTATION + "T" + VALID_TIME_AMY_CONSULTATION);
        Consultation expectedConsultation = new Consultation(VALID_NAME_AMY, t);
        String u = CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION + DATE_DESC_AMY_CONSULTATION
                + TIME_DESC_AMY_CONSULTATION;
        assertParseSuccess(parser, u, new AddConsultationCommand(expectedConsultation));
    }

    @Test
    public void parseMasteryCheck_allFieldsPresent_success() {
        MasteryCheck expectedMasteryCheck = new MasteryCheck(VALID_NAME_AMY,
                LocalDateTime.parse(VALID_DATE_AMY_CONSULTATION + "T" + VALID_TIME_AMY_CONSULTATION));
        assertParseSuccess(parser, MASTERY_CHECK_PREFIX + " " + NAME_DESC_AMY_CONSULTATION
                        + DATE_DESC_AMY_CONSULTATION + TIME_DESC_AMY_CONSULTATION,
                new AddMasteryCheckCommand(expectedMasteryCheck));
    }

    @Test
    public void parseConsultation_compulsoryFieldMissing_failure() {
        String expectedConsultationMessage =
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddConsultationCommand.MESSAGE_ADD_USAGE);

        String expectedConsultationMessage2 =
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_MISSING_INFO);

        String expectedConsultationMessage3 =
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT);

        // Consultation - missing name prefix
        assertParseFailure(parser, CONSULTATION_PREFIX + VALID_NAME_AMY + DATE_DESC_AMY_CONSULTATION
                + TIME_DESC_AMY_CONSULTATION, expectedConsultationMessage);

        // Consultation - missing date prefix
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                + VALID_DATE_AMY_CONSULTATION + TIME_DESC_AMY_CONSULTATION, expectedConsultationMessage2);

        // Consultation - missing time prefix
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                + DATE_DESC_AMY_CONSULTATION + VALID_TIME_AMY_CONSULTATION, expectedConsultationMessage3);

        // Consultation - all prefixes missing
        assertParseFailure(parser, CONSULTATION_PREFIX + VALID_NAME_AMY + VALID_DATE_AMY_CONSULTATION
                + VALID_TIME_AMY_CONSULTATION, expectedConsultationMessage);
    }

    @Test
    public void parseMasteryCheck_compulsoryFieldMissing_failure() {
        String expectedMasteryCheckMessage =
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddMasteryCheckCommand.MESSAGE_ADD_USAGE);

        String expectedMasteryCheckMessage2 =
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddMasteryCheckCommand.MESSAGE_MISSING_INFO);

        String expectedMasteryCheckMessage3 =
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT);

        // MasteryCheck - missing name prefix
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + VALID_NAME_AMY + DATE_DESC_AMY_CONSULTATION
                        + TIME_DESC_AMY_CONSULTATION, expectedMasteryCheckMessage);

        // MasteryCheck - missing date prefix
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                + VALID_DATE_AMY_CONSULTATION + TIME_DESC_AMY_CONSULTATION, expectedMasteryCheckMessage2);

        // MasteryCheck - missing time prefix
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                + DATE_DESC_AMY_CONSULTATION + VALID_TIME_AMY_CONSULTATION, expectedMasteryCheckMessage3);

        // MasteryCheck - all prefixes missing
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + VALID_NAME_AMY + VALID_DATE_AMY_CONSULTATION
                        + VALID_TIME_AMY_CONSULTATION, expectedMasteryCheckMessage);
    }

    @Test
    public void parseConsultation_invalidValue_failure() {
        // invalid date 1
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_ONE_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 2
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_TWO_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 3
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_THREE_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 4
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_FOUR_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 5
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_FIVE_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 6
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_SIX_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 7
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_SEVEN_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 8
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_EIGHT_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid time 1
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + DATE_DESC_AMY_CONSULTATION + INVALID_TIME_ONE_WITH_PREFIX,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid time 2
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + DATE_DESC_AMY_CONSULTATION + INVALID_TIME_TWO_WITH_PREFIX,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid time 3
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + DATE_DESC_AMY_CONSULTATION + INVALID_TIME_THREE_WITH_PREFIX,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid time 4
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + DATE_DESC_AMY_CONSULTATION + INVALID_TIME_FOUR_WITH_PREFIX,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // both invalid date and time
        assertParseFailure(parser, CONSULTATION_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_ONE_WITH_PREFIX + INVALID_TIME_ONE_WITH_PREFIX,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // non-empty preamble
        assertParseFailure(parser, CONSULTATION_PREFIX + PREAMBLE_NON_EMPTY + NAME_DESC_AMY_CONSULTATION
                        + VALID_DATE_AMY_CONSULTATION + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddConsultationCommand.MESSAGE_ADD_USAGE));
    }

    @Test
    public void parseMasteryCheck_invalidValue_failure() {
        // invalid date 1
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_ONE_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 2
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_TWO_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 3
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_THREE_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 4
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_FOUR_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 5
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_FIVE_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 6
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_SIX_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 7
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_SEVEN_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid date 8
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_EIGHT_WITH_PREFIX + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid time 1
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + DATE_DESC_AMY_CONSULTATION + INVALID_TIME_ONE_WITH_PREFIX,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid time 2
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + DATE_DESC_AMY_CONSULTATION + INVALID_TIME_TWO_WITH_PREFIX,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid time 3
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + DATE_DESC_AMY_CONSULTATION + INVALID_TIME_THREE_WITH_PREFIX,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // invalid time 4
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + DATE_DESC_AMY_CONSULTATION + INVALID_TIME_FOUR_WITH_PREFIX,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // both invalid date and time
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + NAME_DESC_AMY_CONSULTATION
                        + INVALID_DATE_ONE_WITH_PREFIX + INVALID_TIME_ONE_WITH_PREFIX,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_WRONG_DATETIME_FORMAT));

        // non-empty preamble
        assertParseFailure(parser, MASTERY_CHECK_PREFIX + PREAMBLE_NON_EMPTY
                        + NAME_DESC_AMY_CONSULTATION + VALID_DATE_AMY_CONSULTATION + VALID_TIME_AMY_CONSULTATION,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddConsultationCommand.MESSAGE_ADD_USAGE));
    }
}
