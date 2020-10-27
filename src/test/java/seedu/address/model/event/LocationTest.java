package seedu.address.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class LocationTest {
    private static final String LOCATION_WITH_CAROT = "^";
    private static final String LOCATION_WITH_AT = "Dining Hall@Eusoff";
    private static final String LOCATION_WITH_SLASH = "Dining Hall/Function Hall";
    private static final String LOCATION_WITH_TRAILING_SPACES = "Dining Hall!   ";
    private static final String LOCATION_WITH_LEADING_SPACES = "   Dining Hall!";

    @Test
    void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Location(null));
    }

    @Test
    void constructor_invalidLocation_throwsIllegalValueException() {
        assertThrows(IllegalArgumentException.class, () -> new Location(""));
        assertThrows(IllegalArgumentException.class, () -> new Location("  "));
        assertThrows(IllegalArgumentException.class, () -> new Location("     "));

        // inputs with leading spaces are rejected
        assertThrows(IllegalArgumentException.class, () -> new Location(LOCATION_WITH_LEADING_SPACES));
    }

    @Test
    void constructor_validLocation_success() {
        assertNotNull(new Location(LOCATION_WITH_CAROT));
        assertNotNull(new Location(LOCATION_WITH_AT));
        assertNotNull(new Location(LOCATION_WITH_SLASH));
        assertNotNull(new Location(LOCATION_WITH_TRAILING_SPACES));
    }

    @Test
    void isValidLocation() {
        assertThrows(NullPointerException.class, () -> Location.isValidLocation(null));

        assertFalse(Location.isValidLocation(""));
        assertFalse(Location.isValidLocation("  "));
        assertFalse(Location.isValidLocation(LOCATION_WITH_LEADING_SPACES));

        assertTrue(Location.isValidLocation(LOCATION_WITH_CAROT));
        assertTrue(Location.isValidLocation(LOCATION_WITH_AT));
        assertTrue(Location.isValidLocation(LOCATION_WITH_SLASH));
        assertTrue(Location.isValidLocation(LOCATION_WITH_TRAILING_SPACES));
    }

    @Test
    void testHashCode() {
        int testHashCode = new Location(LOCATION_WITH_SLASH).hashCode();
        assertEquals(testHashCode, new Location(LOCATION_WITH_SLASH).hashCode());
    }
}
