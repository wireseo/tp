package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.student.Student;
import seedu.address.model.task.Task;

/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableAddressBook {

    public static final String MESSAGE_DUPLICATE_STUDENT = "Students list contains duplicate student(s).";
    public static final String MESSAGE_DUPLICATE_TASK = "Tasks list contains duplicate task(s).";

    private String name = "";

    private final List<JsonAdaptedStudent> students = new ArrayList<>();

    private final List<JsonAdaptedMission> missions = new ArrayList<>();

    private final List<JsonAdaptedQuest> quests = new ArrayList<>();

    private final List<JsonAdaptedTask> tasks = new ArrayList<>();

    private final List<JsonAdaptedConsultation> consultations = new ArrayList<>();

    private final List<JsonAdaptedMasteryCheck> masteryChecks = new ArrayList<>();


    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given fields.
     */
    @JsonCreator
    public JsonSerializableAddressBook(
            @JsonProperty("name") String name,
            @JsonProperty("students") List<JsonAdaptedStudent> students,
            @JsonProperty("missions") List<JsonAdaptedMission> missions,
            @JsonProperty("quests") List<JsonAdaptedQuest> quests,
            @JsonProperty("tasks") List<JsonAdaptedTask> tasks,
            @JsonProperty("consultations") List<JsonAdaptedConsultation> consultations,
            @JsonProperty("masteryChecks") List<JsonAdaptedMasteryCheck> masteryChecks,
            @JsonProperty("tasks") List<JsonAdaptedTask> tasks) {
        this.name = name;
        this.students.addAll(students);
        this.missions.addAll(missions);
        this.quests.addAll(quests);
        this.tasks.addAll(tasks);
        this.consultations.addAll(consultations);
        this.masteryChecks.addAll(masteryChecks);
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableAddressBook(ReadOnlyAddressBook source) {
        name = source.getName();
        students.addAll(source.getStudentList().stream().map(JsonAdaptedStudent::new).collect(Collectors.toList()));
        tasks.addAll(source.getTaskList().stream().map(JsonAdaptedTask::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public AddressBook toModelType() throws IllegalValueException {
        AddressBook addressBook = new AddressBook();

        // Students
        for (JsonAdaptedStudent jsonAdaptedStudent : students) {
            Student student = jsonAdaptedStudent.toModelType();
            if (addressBook.hasStudent(student)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_STUDENT);
            }
            addressBook.addStudent(student);
        }

        // Tasks
        for (JsonAdaptedTask jsonAdaptedTask : tasks) {
            Task task = jsonAdaptedTask.toModelType();
            if (addressBook.hasTask(task)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_TASK);
            }
            addressBook.addTask(task);
        }

        addressBook.setName(name);

        return addressBook;
    }

}
