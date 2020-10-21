package seedu.address.model.util;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.Telegram;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Student[] getSamplePersons() {
        return new Student[] {
            new Student(new Name("Alex Yeoh"), new Telegram("87438807"), new Email("alexyeoh@example.com")),
            new Student(new Name("Bernice Yu"), new Telegram("99272758"), new Email("berniceyu@example.com")),
            new Student(new Name("Charlotte Oliveiro"), new Telegram("93210283"),
                    new Email("charlotte@example.com")),
            new Student(new Name("David Li"), new Telegram("91031282"), new Email("lidavid@example.com")),
            new Student(new Name("Irfan Ibrahim"), new Telegram("92492021"), new Email("irfan@example.com")),
            new Student(new Name("Roy Balakrishnan"), new Telegram("92624417"), new Email("royb@example.com"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Student sampleStudent : getSamplePersons()) {
            sampleAb.addStudent(sampleStudent);
        }
        return sampleAb;
    }
}
