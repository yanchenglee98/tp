package seedu.address.model.event;

import static java.util.Objects.requireNonNull;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.event.exceptions.DuplicateEventException;
import seedu.address.model.event.exceptions.EventNotFoundException;

/**
 * A list of events that enforces uniqueness between its elements and does not allow nulls.
 * An event is considered unique using {@code Event#isSameEvent}. As such, adding and updating of
 * events uses #Event#isSameEvent(Event) for equality so as to ensure the event being added is
 * unique in terms of identity in the UniqueEventList. However, the removal of an event uses Event#equals so
 * as to ensure that the event with the exact same fields will be removed.
 */
public class UniqueEventList implements Iterable<Event> {

    private final ObservableList<Event> internalList =
            FXCollections.observableArrayList();
    private final ObservableList<Event> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Creates a dummy implementation for UniqueEventList.
     */
    public UniqueEventList() {
        Event dummy1 = new Event(new EventName("Hall supper"), new Description("Have supper together"));
        Event dummy2 = new Event(new EventName("Hall dinner"), new Description("Have dinner together"));

        internalList.add(dummy1);
        internalList.add(dummy2);
    }

    /**
     * Returns true if the list contains an equivalent event in the given argument.
     */
    public boolean contains(Event toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameEvent);
    }

    /**
     * Adds an event to the list.
     * The event must not already exist in the list.
     */
    public void add(Event toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateEventException();
        }
        internalList.add(toAdd);
    }

    /**
     * Removes the equivalent event from the list.
     * The event must exist in the list.
     */
    public void remove(Event toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new EventNotFoundException();
        }
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Event> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Event> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueEventList // instanceof handles nulls
                && internalList.equals(((UniqueEventList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }
}
