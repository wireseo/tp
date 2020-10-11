package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.mission.Mission;

/**
 * Panel containing the list of persons.
 */
public class MissionListPanel extends UiPart<Region> {
    private static final String FXML = "MissionListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(MissionListPanel.class);

    @FXML
    private ListView<Mission> missionListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public MissionListPanel(ObservableList<Mission> missionList) {
        super(FXML);
        missionListView.setItems(missionList);
        missionListView.setCellFactory(listView -> new MissionListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Student} using a {@code PersonCard}.
     */
    class MissionListViewCell extends ListCell<Mission> {
        @Override
        protected void updateItem(Mission mission, boolean empty) {
            super.updateItem(mission, empty);

            if (empty || mission == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new MissionCard(mission, getIndex() + 1).getRoot());
            }
        }
    }

}
