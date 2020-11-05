package seedu.address.model;

import java.nio.file.Path;

import seedu.address.commons.core.GuiSettings;

/**
 * Unmodifiable view of user prefs.
 */
public interface ReadOnlyUserPrefs {

    GuiSettings getGuiSettings();
    Path getAddressBookFilePath();
    String[] getBlockSettings();
    int getMinRoomSettings();
    void setMinRoomSettings(int minRoomSettings);
    int getMaxRoomSettings();
    void setMaxRoomSettings(int maxRoomSettings);
    int getMinFloorSettings();
    void setMinFloorSettings(int minFloorSettings);
    int getMaxFloorSettings();
    void setMaxFloorSettings(int maxFloorSettings);

}
