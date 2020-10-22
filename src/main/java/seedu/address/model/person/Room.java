package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Room number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidRoom(String)}
 */
public class Room {

    public static final String MESSAGE_CONSTRAINTS =
            "Room numbers should only contain numbers, and it should be 3 digits long";
    public static final String VALIDATION_REGEX = "\\d{3}";
    private static int roomPref = 420;
    public final String value;

    /**
     * Constructs a {@code Room}.
     *
     * @param room A valid Room number.
     */
    public Room(String room) {
        requireNonNull(room);
        checkArgument(isValidRoom(room), MESSAGE_CONSTRAINTS);
        value = room;
    }

    /**
     * Returns true if a given string is a valid Room number.
     */
    public static boolean isValidRoom(String test) {
        if (!test.matches(VALIDATION_REGEX)) {
            return false;
        }
        int room = Integer.parseInt(test);
        boolean isRoomValid = room % 100 <= roomPref % 100 && room % 100 > 0;
        boolean isFloorValid = Math.floorDiv(room, 100) <= Math.floorDiv(roomPref, 100)
                && Math.floorDiv(room, 100) > 0;
        return isFloorValid && isRoomValid;
    }

    public static String getMessageConstraints() {
        int floorMax = Math.floorDiv(roomPref, 100);
        int roomMax = roomPref % 100;
        return MESSAGE_CONSTRAINTS + "\nFloor : 1 to " + String.valueOf(floorMax)
                + "\nRoom No : 1 to " + String.valueOf(roomMax);
    }

    public static void setRoomPref(int pref) {
        roomPref = pref;
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
