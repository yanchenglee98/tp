package seedu.address.model.event;

public class Event {
    //TODO: [Event] Complete the class
    private final String eventName;
    private final AttendeesList attendeesList;

    /**
     * Constructs a dummy implementation of event.
     * @param eventName name of the event
     */
    public Event(String eventName) {
        this.eventName = eventName;
        this.attendeesList = new AttendeesList();
    }

    public String getName() {
        return eventName;
    }

    public AttendeesList getAttendeesList() {
        return attendeesList;
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

    @Override
    public String toString() {
        return eventName;
    }
}
