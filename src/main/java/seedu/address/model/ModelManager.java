package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.mission.Mission;
import seedu.address.model.quest.Quest;
import seedu.address.model.student.Student;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Event;
import seedu.address.model.task.Task;
import seedu.address.model.task.Todo;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final AddressBook addressBook;
    private final UserLogin userLogin;
    private final UserPrefs userPrefs;
    private final FilteredList<Student> filteredStudents;
    private final FilteredList<Mission> filteredMissions;
    private final FilteredList<Quest> filteredQuests;
    private final FilteredList<Task> filteredTasks;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs, ReadOnlyUserLogin userLogin) {
        super();
        requireAllNonNull(addressBook, userPrefs);

        logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);

        this.addressBook = new AddressBook(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        this.userLogin = new UserLogin(userLogin);
        filteredStudents = new FilteredList<>(this.addressBook.getStudentList());
        filteredMissions = new FilteredList<>(this.addressBook.getMissionList());
        filteredQuests = new FilteredList<>(this.addressBook.getQuestList());
        filteredTasks = new FilteredList<>(this.addressBook.getTaskList());
    }

    public ModelManager() {
        this(new AddressBook(), new UserPrefs(), new UserLogin());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }
    //=========== UserLogin ==================================================================================

    @Override
    public boolean hasUsername() {
        return userLogin.hasUsername();
    }

    @Override
    public boolean hasPassword() {
        return userLogin.hasPassword();
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        this.addressBook.resetData(addressBook);
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    @Override
    public boolean hasPerson(Student student) {
        requireNonNull(student);
        return addressBook.hasStudent(student);
    }

    @Override
    public void deletePerson(Student target) {
        addressBook.removeStudent(target);
    }

    @Override
    public void addPerson(Student student) {
        addressBook.addStudent(student);
        updateFilteredPersonList(PREDICATE_SHOW_ALL_STUDENTS);
    }

    @Override
    public void setStudents(List<Student> students) {
        addressBook.setStudents(students);
    }

    @Override
    public void setPerson(Student target, Student editedStudent) {
        requireAllNonNull(target, editedStudent);

        addressBook.setPerson(target, editedStudent);
    }

    @Override
    public boolean hasStudents() {
        return addressBook.hasStudents();
    }

    //=========== Missions ===================================================================================
    @Override
    public void addMission(Mission mission) {
        addressBook.addMission(mission);
    }

    @Override
    public void setMissions(List<Mission> missions) {
        addressBook.setMissions(missions);
    }

    //=========== Filtered Mission List Accessors =============================================================
    @Override
    public void updateMissionsList(Predicate<Mission> predicate) {
        requireNonNull(predicate);
        filteredMissions.setPredicate(predicate);
    }

    /**
     * Returns an unmodifiable view of the list of {@code Mission} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Mission> getFilteredMissionList() {
        return filteredMissions;
    }

    /**
     * Returns an unmodifiable view of the list of {@code Student} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Student> getFilteredPersonList() {
        return filteredStudents;
    }

    //=========== Quests ===================================================================================
    @Override
    public void addQuest(Quest quest) {
        addressBook.addQuest(quest);
    }

    @Override
    public void setQuests(List<Quest> quests) {
        addressBook.setQuests(quests);
    }

    /**
     * Returns an unmodifiable view of the list of {@code Quest} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Quest> getFilteredQuestList() {
        return filteredQuests;
    }

    @Override
    public void updateQuestsList(Predicate<Quest> predicate) {
        requireNonNull(predicate);
        filteredQuests.setPredicate(predicate);
    }

    @Override
    public void updateFilteredPersonList(Predicate<Student> predicate) {
        requireNonNull(predicate);
        filteredStudents.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return addressBook.equals(other.addressBook)
                && userPrefs.equals(other.userPrefs)
                && filteredStudents.equals(other.filteredStudents);
    }

    //============================== Task ====================================================================
    @Override
    public boolean hasTodo(Todo todo) {
        requireNonNull(todo);
        return addressBook.hasTodo(todo);
    }

    @Override
    public void addTodo(Todo todo) {
        addressBook.addTodo(todo);
    }

    @Override
    public boolean hasEvent(Event event) {
        requireNonNull(event);
        return addressBook.hasEvent(event);
    }

    @Override
    public void addEvent(Event event) {
        addressBook.addEvent(event);
    }

    @Override
    public boolean hasDeadline(Deadline deadline) {
        requireNonNull(deadline);
        return addressBook.hasDeadline(deadline);
    }

    @Override
    public void addDeadline(Deadline deadline) {
        addressBook.addDeadline(deadline);
    }

    @Override
    public boolean hasConsultation(Consultation consultation) {
        requireNonNull(consultation);
        return addressBook.hasConsultation(consultation);
    }

    @Override
    public void addConsultation(Consultation consultation) {
        addressBook.addConsultation(consultation);
    }

    @Override
    public List<Consultation> getConsultations(Predicate<Consultation> predicate) {
        List<Consultation> allConsultations = new ArrayList<Consultation>();
        addressBook.getStudentList().forEach(student -> student.getConsultations().stream().filter(predicate)
                .forEach(consultation -> allConsultations.add(consultation)));
        return allConsultations;
    }

    @Override
    public boolean isMissionInList(String title) {
        assert title.length() > 0 : "No mission title provided";
        return addressBook.isMissionInList(title);
    }

    @Override
    public boolean updateMission(String name) {
        assert name.length() > 0 : "No mission title provided";
        return addressBook.updateMission(name);
    }

    @Override
    public boolean isQuestInList(String title) {
        assert title.length() > 0 : "No quest title provided";
        return addressBook.isQuestInList(title);
    }

    @Override
    public boolean updateQuest(String name) {
        assert name.length() > 0 : "No quest title provided";
        return addressBook.updateQuest(name);
    }

}
