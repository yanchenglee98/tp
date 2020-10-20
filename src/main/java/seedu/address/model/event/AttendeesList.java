package seedu.address.model.event;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.person.Person;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;

import static java.util.Objects.requireNonNull;

public class AttendeesList {
    private final List<Person> attendeesList = new ArrayList<>();

    public List<Person> getAttendees() {
        return attendeesList;
    }

    public boolean contains(Person toCheck) {
        requireNonNull(toCheck);
        return attendeesList.stream().anyMatch(toCheck::isSamePerson);
    }

    public void add(Person toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
        attendeesList.add(toAdd);
    }

    public void remove(Person toRemove) {
        requireNonNull(toRemove);
        if (!attendeesList.remove(toRemove)) {
            throw new PersonNotFoundException();
        }
    }
}
