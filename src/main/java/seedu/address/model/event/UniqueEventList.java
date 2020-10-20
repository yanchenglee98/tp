package seedu.address.model.event;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UniqueEventList implements Iterable<Event> {
    //TODO: [Event] add functions

    private final ObservableList<Event> internalList =
            FXCollections.observableArrayList(new Event("Hall dinner"), new Event("Hall supper"));
    private final ObservableList<Event> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

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
}
