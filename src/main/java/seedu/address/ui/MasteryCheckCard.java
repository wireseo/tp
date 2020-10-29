package seedu.address.ui;

import java.time.LocalDateTime;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.consultation.Consultation;

public class MasteryCheckCard extends UiPart<Region> {

    private static final String FXML = "MasteryCheckListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Consultation masteryCheck;

    @javafx.fxml.FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label studentName;
    @FXML
    private Label dateAndTime;

    /**
     * Creates a {@code ConsultationCard} with the given {@code Consultation} and index to display.
     */
    public MasteryCheckCard(Consultation masteryCheck, int displayedIndex) {
        super(FXML);
        this.masteryCheck = masteryCheck;
        id.setText(displayedIndex + ". ");
        studentName.setText(masteryCheck.getStudentName());
        LocalDateTime localDateTime = masteryCheck.getDateAndTime();
        String date = localDateTime.toLocalDate().toString();
        String time = localDateTime.toLocalTime().toString();
        dateAndTime.setText("Details: " + date + " at " + time);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MasteryCheckCard)) {
            return false;
        }

        // state check
        MasteryCheckCard card = (MasteryCheckCard) other;
        return id.getText().equals(card.id.getText())
                && masteryCheck.equals(card.masteryCheck);
    }
}
