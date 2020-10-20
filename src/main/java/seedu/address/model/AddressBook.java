package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.mission.Mission;
import seedu.address.model.mission.MissionList;
import seedu.address.model.quest.Quest;
import seedu.address.model.quest.QuestList;
import seedu.address.model.student.Student;
import seedu.address.model.student.UniqueStudentsList;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Event;
import seedu.address.model.task.Task;
import seedu.address.model.task.Todo;
import seedu.address.model.task.UniqueTasksList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniqueStudentsList students;

    private final MissionList missions;

    private final QuestList quests;

    private final UniqueTasksList tasks;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        students = new UniqueStudentsList();
        missions = new MissionList();
        tasks = new UniqueTasksList();
        quests = new QuestList();
    }

    public AddressBook() {}

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the student list with {@code students}.
     * {@code students} must not contain duplicate students.
     */
    public void setStudents(List<Student> students) {
        this.students.setPersons(students);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);

        setStudents(newData.getStudentList());
        setMissions(newData.getMissionList());
        setQuests(newData.getQuestList());
    }

    //// student-level operations

    /**
     * Returns true if a student with the same identity as {@code student} exists in the address book.
     */
    public boolean hasStudent(Student student) {
        requireNonNull(student);
        return students.contains(student);
    }

    /**
     * Adds a student to the address book.
     * The student must not already exist in the address book.
     */
    public void addStudent(Student p) {
        students.add(p);
    }

    /**
     * Replaces the given student {@code target} in the list with {@code editedStudent}.
     * {@code target} must exist in the address book.
     * The student identity of {@code editedStudent} must not be the same as another existing
     * student in the address book.
     */
    public void setPerson(Student target, Student editedStudent) {
        requireNonNull(editedStudent);

        students.setPerson(target, editedStudent);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeStudent(Student key) {
        students.remove(key);
    }

    //// util methods

    /**
     * Returns whether student list has students already.
     * @return a boolean
     */
    public boolean hasStudents() {
        return students.hasStudents();
    }

    @Override
    public String toString() {
        return students.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public ObservableList<Student> getStudentList() {
        return students.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Mission> getMissionList() {
        return this.missions.asObservableList();
    }

    @Override
    public ObservableList<Quest> getQuestList() {
        return this.quests.asObservableList();
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    public void setMissions(List<Mission> missions) {
        this.missions.setMissions(missions);
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public void setQuests(List<Quest> quests) {
        this.quests.setQuests(quests);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                && students.equals(((AddressBook) other).students));
    }

    @Override
    public int hashCode() {
        return students.hashCode();
    }


    //======================== Tasks ==========================================================================
    /**
     * Returns true if a todo with the same identity as {@code todo} exists in the address book.
     */
    public boolean hasTodo(Todo todo) {
        requireNonNull(todo);
        return tasks.contains(todo);
    }

    /**
     * Adds a todo to the address book.
     * The todo must not already exist in the address book.
     */
    public void addTodo(Todo todo) {
        this.tasks.add(todo);
    }

    /**
     * Returns true if a event with the same identity as {@code event} exists in the address book.
     */
    public boolean hasEvent(Event event) {
        requireNonNull(event);
        return tasks.contains(event);
    }

    /**
     * Adds an event to the address book.
     * The event must not already exist in the address book.
     */
    public void addEvent(Event event) {
        this.tasks.add(event);
    }

    /**
     * Returns true if a deadline with the same identity as {@code deadline} exists in the address book.
     */
    public boolean hasDeadline(Deadline deadline) {
        requireNonNull(deadline);
        return tasks.contains(deadline);
    }

    /**
     * Adds a deadline to the address book.
     * The deadline must not already exist in the address book.
     */
    public void addDeadline(Deadline deadline) {
        this.tasks.add(deadline);
    }

    /**
     * Returns true if a consultation with the same identity as {@code deadline} exists in the address book.
     */
    public boolean hasConsultation(Consultation consultation) {
        requireNonNull(consultation);
        return students.containsConsultation(consultation);
    }

    /**
     * Adds a consultation to the address book.
     * The consultation must not already exist in the address book.
     */
    public void addConsultation(Consultation consultation) {
        //this.students.addConsultation(consultation); TODO: NEED TO IMPLEMENT THIS METHOD!!!
    }

    /**
     * Returns true if a task with the same identity as {@code task} exists in the address book.
     */
    public boolean hasTask(Task task) {
        requireNonNull(task);
        return tasks.contains(task);
    }

    /**
     * Adds a task to the address book.
     * The task must not already exist in the address book.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    @Override
    public ObservableList<Task> getTaskList() {
        return this.tasks.asObservableList();
    }

    public boolean isMissionInList(String name) {
        return this.missions.isMissionInList(name);
    }

    public boolean updateMission(String name) {
        return this.missions.updateMission(name);
    }

}
