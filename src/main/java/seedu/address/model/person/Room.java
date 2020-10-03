package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Room number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidRoom(String)}
 */
public class Room {


    public static final String MESSAGE_CONSTRAINTS =
            "Room numbers should only contain numbers, and it should be at least 3 digits long";
    public static final String VALIDATION_REGEX = "\\d{1,}";
    public final String value;

    /**
     * Constructs a {@code Room}.
     *
     * @param Room A valid Room number.
     */
    public Room(String Room) {
        requireNonNull(Room);
        checkArgument(isValidRoom(Room), MESSAGE_CONSTRAINTS);
        value = Room;
    }

    /**
     * Returns true if a given string is a valid Room number.
     */
    public static boolean isValidRoom(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Room // instanceof handles nulls
                && value.equals(((Room) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
