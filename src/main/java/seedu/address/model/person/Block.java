package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Block number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class Block {


    public static final String MESSAGE_CONSTRAINTS =
            "Block should only contain alphabets";
    public static final String VALIDATION_REGEX = "[a-zA-Z]";
    public final String value;

    /**
     * Constructs a {@code Block}.
     *
     * @param block A valid Block number.
     */
    public Block(String block) {
        requireNonNull(block);
        checkArgument(isValidBlock(block), MESSAGE_CONSTRAINTS);
        value = block.toUpperCase();
    }

    /**
     * Returns true if a given string is a valid Block number.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
