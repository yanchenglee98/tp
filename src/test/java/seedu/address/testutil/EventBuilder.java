package seedu.address.testutil;

import seedu.address.model.event.Description;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventDate;
import seedu.address.model.event.EventName;
import seedu.address.model.event.Location;

/**
 * A utility class to help with building Event objects.
 */
public class EventBuilder {
    public static final String DEFAULT_NAME = "Hall Event X";
    public static final String DEFAULT_DATE = "27/10/2020 15:00";
    public static final String DEFAULT_LOCATION = "Dining Hall";
    public static final String DEFAULT_DESCRIPTION = "The Xth event of the Hall";

    private EventName eventName;
    private EventDate eventDate;
    private Location location;
    private Description description;

    /**
     * Creates a {@code EventBuilder} with the default details.
     */
    public EventBuilder() {
        eventName = new EventName(DEFAULT_NAME);
        eventDate = new EventDate(DEFAULT_DATE);
        location = new Location(DEFAULT_LOCATION);
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
     * Sets the {@code eventDate} of the {@code Event} that we are building.
     */
    public EventBuilder withDate(String date) {
        this.eventDate = new EventDate(date);
        return this;
    }

    /**
     * Sets the {@code location} of the {@code Event} that we are building.
     */
    public EventBuilder withLocation(String location) {
        this.location = new Location(location);
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
        return new Event(eventName, eventDate, location, description);
    }
}
