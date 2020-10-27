package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.function.Predicate;

/**
 * Tests that a {@code Person}'s {@code Room} is in the current level.
 */
public class RoomInLevelPredicate implements Predicate<Person> {
    public static final String MESSAGE_CONSTRAINTS =
            "Level should have only one number inside, ranging from 1 to 4!";


    public static final String VALIDATION_REGEX = "\\d";
    private final String level;

    /**
     * Constructs a {@code RoomInLevelPredicate}.
     *
     * @param level A valid Level.
     */
    public RoomInLevelPredicate(String level) {
        requireNonNull(level);
        checkArgument(isValidLevel(level), MESSAGE_CONSTRAINTS);
        this.level = level;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidLevel(String test) {
        return test.matches(VALIDATION_REGEX)
            &&;
    }

    @Override
    public boolean test(Person person) {
        return person.getRoom().value.startsWith(level);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RoomInLevelPredicate // instanceof handles nulls
                && level.equals(((RoomInLevelPredicate) other).level)); // state check
    }

}
