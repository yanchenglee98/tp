package seedu.address.model.event;

public class Event {
    //TODO: [Event] Complete the class
    private final String eventName;

    public Event(String eventName) {
        this.eventName = eventName;
    }

    public String getName() {
        return eventName;
    }

    @Override
    public int hashCode() {
        return eventName.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Event // instanceof handles nulls
                && eventName.equals(((Event) other).eventName)); // state check
    }
}
