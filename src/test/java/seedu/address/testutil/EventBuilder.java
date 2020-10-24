package seedu.address.testutil;

import seedu.address.model.event.Description;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventName;

/**
 * A utility class to help with building Event objects.
 */
public class EventBuilder {
    public static final String DEFAULT_NAME = "Hall Event X";
    public static final String DEFAULT_DESCRIPTION = "The Xth event of the Hall";

    private EventName eventName;
    private Description description;

    /**
     * Creates a {@code EventBuilder} with the default details.
     */
    public EventBuilder() {
        eventName = new EventName(DEFAULT_NAME);
        description = new Description(DEFAULT_DESCRIPTION);
    }

    /**
     * Initializes the EventBuilder with the data of {@code eventToCopy}
     */
    public EventBuilder(Event event) {
        eventName = event.getName();
        description = event.getDescription();
    }

    /**
     * Sets the {@code eventName} of the {@code Event} that we are building.
     */
    public EventBuilder withEventName(String name) {
        this.eventName = new EventName(name);
        return this;
    }

    /**
     * Sets the {@code description} of the {@code Description} that we are building.
     */
    public EventBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    /**
     * Converts the current {@code EventBuilder} to an actual {@code Event}.
     */
    public Event build() {
        return new Event(eventName, description);
    }
}
