package seedu.address.model.event;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.person.Person;

public class AttendeesList {
    private final List<Person> attendees = new ArrayList<>();

    public List<Person> getAttendees() {
        return attendees;
    }
}
