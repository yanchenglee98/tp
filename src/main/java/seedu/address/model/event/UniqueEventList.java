package seedu.address.model.event;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UniqueEventList implements Iterable<Event> {
    //TODO: [Event] add functions
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
