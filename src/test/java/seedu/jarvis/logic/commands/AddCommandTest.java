package seedu.jarvis.logic.commands;

import static java.util.Objects.requireNonNull;

import java.beans.PropertyChangeListener;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import seedu.jarvis.commons.core.GuiSettings;
import seedu.jarvis.model.AddressBook;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.ReadOnlyAddressBook;
import seedu.jarvis.model.ReadOnlyUserLogin;
import seedu.jarvis.model.ReadOnlyUserPrefs;
import seedu.jarvis.model.UserLogin;
import seedu.jarvis.model.consultation.Consultation;
import seedu.jarvis.model.consultation.MasteryCheck;
import seedu.jarvis.model.mission.Mission;
import seedu.jarvis.model.quest.Quest;
import seedu.jarvis.model.student.Student;
import seedu.jarvis.model.task.Deadline;
import seedu.jarvis.model.task.Event;
import seedu.jarvis.model.task.Task;
import seedu.jarvis.model.task.Todo;

public class AddCommandTest {
    /*
    @Test
    public void constructor_nullStudent_throwsNullPointerException() {
        Student student = null;
        assertThrows(NullPointerException.class, () -> new AddCommand(student));
    }

    @Test
    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
        Student validStudent = new StudentBuilder().build();

        CommandResult commandResult = new AddCommand(validStudent).execute(modelStub);

        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validStudent), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validStudent), modelStub.personsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Student validStudent = new StudentBuilder().build();
        AddCommand addCommand = new AddCommand(validStudent);
        ModelStub modelStub = new ModelStubWithPerson(validStudent);

        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PERSON, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Student alice = new StudentBuilder().withName("Alice").build();
        Student bob = new StudentBuilder().withName("Bob").build();
        AddCommand addAliceCommand = new AddCommand(alice);
        AddCommand addBobCommand = new AddCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddCommand addAliceCommandCopy = new AddCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different student -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }
    */

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public UserLogin getUserLogin() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUserLogin(ReadOnlyUserLogin userLogin) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasUsername() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPassword() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Student student) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setStudents(List<Student> students) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Student student) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Student target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Student target, Student editedStudent) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Student> getFilteredStudentList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Mission> getFilteredMissionList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Quest> getFilteredQuestList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Student> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasStudents() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateMissionsList(Predicate<Mission> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setQuests(List<Quest> quests) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateQuestsList(Predicate<Quest> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Consultation> getFilteredConsultationsList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateConsultationsList(Predicate<Consultation> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean isConsultationInList(String identifier) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addMission(Mission mission) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setMissions(List<Mission> missions) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addQuest(Quest quest) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasTodo(Todo todo) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasEvent(Event event) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasDeadline(Deadline deadline) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasConsultation(Consultation consultation) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addMasteryCheck(MasteryCheck masteryCheck) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setMasteryChecks(List<MasteryCheck> masteryChecks) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<MasteryCheck> getFilteredMasteryChecksList() {
            return null;
        }

        @Override
        public void updateMasteryChecksList(Predicate<MasteryCheck> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean isMasteryCheckInList(String identifier) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasMasteryCheck(MasteryCheck toAddMasteryCheck) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTodo(Todo todo) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addEvent(Event event) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addDeadline(Deadline deadline) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTask(Task target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addConsultation(Consultation consultation) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setConsultations(List<Consultation> consultations) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredTaskList(Predicate<Task> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Task> getFilteredTaskList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean isMissionInList(String title) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean updateMission(String name) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean isQuestInList(String title) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean updateQuest(String name) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener pcv) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public StringProperty getGreeting() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasGreeting() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGreeting(String name) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single student.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Student student;

        ModelStubWithPerson(Student student) {
            requireNonNull(student);
            this.student = student;
        }

        @Override
        public boolean hasPerson(Student student) {
            requireNonNull(student);
            return this.student.isSamePerson(student);
        }
    }

    /**
     * A Model stub that always accept the student being added.
     */
    private class ModelStubAcceptingPersonAdded extends ModelStub {
        final ArrayList<Student> personsAdded = new ArrayList<>();

        @Override
        public boolean hasPerson(Student student) {
            requireNonNull(student);
            return personsAdded.stream().anyMatch(student::isSamePerson);
        }

        @Override
        public void addPerson(Student student) {
            requireNonNull(student);
            personsAdded.add(student);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
