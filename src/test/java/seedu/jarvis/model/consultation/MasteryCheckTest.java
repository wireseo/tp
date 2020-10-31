package seedu.jarvis.model.consultation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import seedu.jarvis.testutil.StudentBuilder;


public class MasteryCheckTest {
    // TODO: ADD MORE TESTS

    private String studentName = new StudentBuilder().build().getName().fullName;
    private String studentName2 = "StudentName";


    private MasteryCheck normalConsultation = MasteryCheck.createFullMarkMC(studentName, LocalDateTime.of(2020,
            1, 8, 13, 10));
    private MasteryCheck consultationVariant1 = MasteryCheck.createFullMarkMC(studentName2, LocalDateTime.of(2020,
            1, 8, 13, 10));
    private MasteryCheck consultationVariant2 = MasteryCheck.createFullMarkMC(studentName, LocalDateTime.of(2020,
            1, 9, 13, 10));

    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(normalConsultation.equals(normalConsultation));

        // null -> returns false
        assertFalse(normalConsultation.equals(null));

        // different date -> returns false
        assertFalse(normalConsultation.equals(consultationVariant2));

        // different name -> returns false
        assertFalse(normalConsultation.equals(consultationVariant1));

    }

    @Test
    public void conflictsWith() {
        // same dateandtime -> returns true
        assertTrue(normalConsultation.conflictsWith(consultationVariant1));

        // different dateandtime -> returns false
        assertFalse(normalConsultation.conflictsWith(consultationVariant2));
    }
}
