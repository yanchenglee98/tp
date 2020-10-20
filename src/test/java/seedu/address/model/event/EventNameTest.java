package seedu.address.model.event;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class EventNameTest {
    private static final String NAME_WITH_CAROT = "^";
    private static final String NAME_WITH_AT = "Dinner@Hall";
    private static final String NAME_WITH_SLASH = "Hello/World.";
    private static final String NAME_WITH_TRAILING_SPACES = "Hall Event!   ";
    private static final String NAME_WITH_LEADING_SPACES = "   Hall Event";

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new EventName(null));
    }

    @Test
    public void constructor_invalidEventName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new EventName(""));
        assertThrows(IllegalArgumentException.class, () -> new EventName(" "));
        assertThrows(IllegalArgumentException.class, () -> new EventName("   "));

        // inputs with leading spaces are rejected
        assertThrows(IllegalArgumentException.class, () -> new EventName(NAME_WITH_LEADING_SPACES));
    }

    @Test
    public void constructor_validEventName_success() {
        assertNotNull(new EventName(NAME_WITH_CAROT));
        assertNotNull(new EventName(NAME_WITH_AT));
        assertNotNull(new EventName(NAME_WITH_SLASH));
        assertNotNull(new EventName(NAME_WITH_TRAILING_SPACES));
    }

    @Test
    public void isValidEventName() {
        assertThrows(NullPointerException.class, () -> EventName.isValidEventName(null));

        assertFalse(EventName.isValidEventName(""));
        assertFalse(EventName.isValidEventName(" "));
        assertFalse(EventName.isValidEventName(NAME_WITH_LEADING_SPACES));

        assertTrue(EventName.isValidEventName(NAME_WITH_CAROT));
        assertTrue(EventName.isValidEventName(NAME_WITH_AT));
        assertTrue(EventName.isValidEventName(NAME_WITH_SLASH));
        assertTrue(EventName.isValidEventName(NAME_WITH_TRAILING_SPACES));
    }

}
