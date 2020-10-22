package seedu.address.storage;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.event.Description;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventName;

/**
 * Jackson-friendly version of {@link Event}
 */
public class JsonAdaptedEvent {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Event %s field is missing";

    private final String eventName;
    private final String description;

    /**
     * Constructs a {@code JsonAdaptedEvent} with the given event details.
     */
    @JsonCreator
    public JsonAdaptedEvent(@JsonProperty("eventName") String eventName,
                            @JsonProperty("description") String description) {
        requireAllNonNull(eventName, description);
        this.eventName = eventName;
        this.description = description;
    }

    /**
     * Converts a given {@code Event} into this class for Jackson use.
     */
    public JsonAdaptedEvent(Event event) {
        requireNonNull(event);
        this.eventName = event.getName().eventName;
        this.description = event.getDescription().description;
    }

    /**
     * Converts this Jackson-friendly adapted event into the model's {@code Event} object.
     *
     */
    public Event toModelType() throws IllegalValueException {
        if (eventName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    EventName.class.getSimpleName()));
        }
        if (!EventName.isValidEventName(eventName)) {
            throw new IllegalValueException(EventName.MESSAGE_CONSTRAINTS);
        }
        final EventName modelName = new EventName(eventName);

        if (description == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Description.class.getSimpleName()));
        }
        if (!Description.isValidDescription(description)) {
            throw new IllegalValueException(Description.MESSAGE_CONSTRAINTS);
        }
        final Description modelDescription = new Description(description);

        return new Event(modelName, modelDescription);
    }

}
