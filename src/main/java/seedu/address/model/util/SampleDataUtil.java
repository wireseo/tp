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
            new Student(new Name("Alex Yeoh"), new Telegram("alexyeoh"), new Email("alexyeoh@example.com")),
            new Student(new Name("Bernice Yu"), new Telegram("berniceyu132"), new Email("berniceyu@example.com")),
            new Student(new Name("Charlotte Oliveiro"), new Telegram("coliverro"),
                    new Email("charlotte@example.com")),
            new Student(new Name("David Li"), new Telegram("davidli"), new Email("lidavid@example.com")),
            new Student(new Name("Irfan Ibrahim"), new Telegram("irfan"), new Email("irfan@example.com")),
            new Student(new Name("Roy Balakrishnan"), new Telegram("royb"), new Email("royb@example.com"))
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
