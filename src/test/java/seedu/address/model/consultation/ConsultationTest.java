package seedu.address.model.consultation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
// TODO: import consultations from testutil as well

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.model.Consultation;



public class ConsultationTest {

    // TODO: Naming constraints

    private Consultation normalConsultation = new Consultation(LocalDate.parse("2020-01-08"), 120,
            "COM2", "");
    private Consultation consultationVariant1 = new Consultation(LocalDate.parse("2020-01-08"), 100,
            "COM2", "");
    private Consultation consultationVariant2 = new Consultation(LocalDate.parse("2020-01-09"), 120,
            "COM2", "");
    private Consultation consultationVariant3 = new Consultation(LocalDate.parse("2020-01-08"), 120,
            "COM3", "");


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

        // same date, same length of meeting, different place of meeting -> returns false
        assertFalse(normalConsultation.equals(consultationVariant3));

    }

    @Test
    public void conflictsWith() {
        // same dateandtime -> returns true
        assertTrue(normalConsultation.conflictsWith(consultationVariant1));

        // different dateandtime -> returns false
        assertFalse(normalConsultation.conflictsWith(consultationVariant2));

    }
}
