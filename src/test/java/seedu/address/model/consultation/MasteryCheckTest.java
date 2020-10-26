package seedu.address.model.consultation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import seedu.address.model.student.Student;
import seedu.address.testutil.StudentBuilder;


public class MasteryCheckTest {
    // TODO: ADD MORE TESTS

    private Student student = new StudentBuilder().build();

    private MasteryCheck normalConsultation = MasteryCheck.createFullMarkMC(student, LocalDateTime.of(2020,
            1, 8, 13, 10), 120, "COM2", "");
    private MasteryCheck consultationVariant1 = MasteryCheck.createFullMarkMC(student, LocalDateTime.of(2020,
            1, 8, 13, 10), 100, "COM2", "");
    private MasteryCheck consultationVariant2 = MasteryCheck.createFullMarkMC(student, LocalDateTime.of(2020,
            1, 9, 13, 10), 120, "COM2", "");
    private MasteryCheck consultationVariant3 = MasteryCheck.createFullMarkMC(student, LocalDateTime.of(2020,
            1, 8, 13, 10), 120, "COM3", "");

    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(normalConsultation.equals(normalConsultation));

        // null -> returns false
        assertFalse(normalConsultation.equals(null));

        // different date -> returns false
        assertFalse(normalConsultation.equals(consultationVariant2));

        // different length of meeting -> returns true
        assertTrue(normalConsultation.equals(consultationVariant1));

        // same date, same length of meeting, different place of meeting -> returns true
        assertTrue(normalConsultation.equals(consultationVariant3));

    }

    @Test
    public void conflictsWith() {
        // same dateandtime -> returns true
        assertTrue(normalConsultation.conflictsWith(consultationVariant1));

        // different dateandtime -> returns false
        assertFalse(normalConsultation.conflictsWith(consultationVariant2));
    }
}
