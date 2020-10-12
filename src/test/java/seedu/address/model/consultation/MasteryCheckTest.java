package seedu.address.model.consultation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.model.MasteryCheck;
import seedu.address.model.student.Student;
import seedu.address.testutil.StudentBuilder;


public class MasteryCheckTest {

    // TODO: Naming constraints

    private MasteryCheck normalConsultation = MasteryCheck.createFullMarkMC(LocalDate.parse("2020-01-08"),
            120, "COM2", "");
    private MasteryCheck consultationVariant1 = MasteryCheck.createFullMarkMC(LocalDate.parse("2020-01-08"),
            100, "COM2", "");
    private MasteryCheck consultationVariant2 = MasteryCheck.createFullMarkMC(LocalDate.parse("2020-01-09"),
            120, "COM2", "");
    private MasteryCheck consultationVariant3 = MasteryCheck.createFullMarkMC(LocalDate.parse("2020-01-08"),
            120, "COM3", "");

    // TODO: Erase this?
    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Student student = new StudentBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> student.getTags().remove(0));
    }

    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(normalConsultation.equals(normalConsultation));

        // null -> returns false
        assertFalse(normalConsultation.equals(null));

        // different date -> returns false
        assertFalse(normalConsultation.equals(consultationVariant2));

        // different length of meeting -> returns false
        assertFalse(normalConsultation.equals(consultationVariant1));

        // same date, same length of meeting, different place of meeting -> returns true
        assertFalse(normalConsultation.equals(consultationVariant3));

    }

    @Test
    public void conflictsWith() {
        // same dateandtime -> returns true
        assertTrue(normalConsultation.equals(consultationVariant1));

        // different dateandtime -> returns false
        assertFalse(normalConsultation.equals(consultationVariant2));

    }
}
