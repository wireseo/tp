package seedu.address.model.greeting;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {
    private static final String DEFAULT_GREETING = "Hi! Please log in to continue";

    private final StringProperty greeting;

    /**
     * Constructs an empty Greeting object.
     */
    public Greeting() {
        this.greeting = new SimpleStringProperty("");
    }

    public boolean isEmpty() {
        return greeting.getValue().isEmpty() || greeting.getValue().equals(DEFAULT_GREETING);
    }

    public StringProperty getGreeting() {
        return greeting;
    }

    public void setGreeting(String newGreeting) {
        if (newGreeting == null || newGreeting.isEmpty() || newGreeting.equals(DEFAULT_GREETING)) {
            this.greeting.setValue(DEFAULT_GREETING);
        } else {
            this.greeting.setValue(padWithIntro(newGreeting));
        }

    }

    public String padWithIntro(String greeting) {
        return "Welcome, " + greeting + "!";
    }

    @Override
    public String toString() {
        return greeting.getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Greeting // instanceof handles nulls
                && greeting.getValue().equals(((Greeting) other).getGreeting().getValue())); // state check
    }

    @Override
    public int hashCode() {
        return greeting.hashCode();
    }
}
