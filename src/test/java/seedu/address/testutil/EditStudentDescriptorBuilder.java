package seedu.address.testutil;

import seedu.address.logic.commands.EditStudentCommand.EditPersonDescriptor;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.Telegram;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditStudentDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditStudentDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditStudentDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code student}'s details
     */
    public EditStudentDescriptorBuilder(Student student) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(student.getName());
        descriptor.setTelegram(student.getTelegram());
        descriptor.setEmail(student.getEmail());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withPhone(String phone) {
        descriptor.setTelegram(new Telegram(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditStudentDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
