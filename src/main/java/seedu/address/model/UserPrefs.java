package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs implements ReadOnlyUserPrefs {

    private GuiSettings guiSettings = new GuiSettings();
    private Path addressBookFilePath = Paths.get("data" , "addressbook.json");
    private String[] blockSettings = {"A", "B", "C", "D"};
    private int minRoomSettings = 1;
    private int maxRoomSettings = 20;
    private int minFloorSettings = 1;
    private int maxFloorSettings = 4;

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public UserPrefs() {}

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public UserPrefs(ReadOnlyUserPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setAddressBookFilePath(newUserPrefs.getAddressBookFilePath());
        setBlockSettings(newUserPrefs.getBlockSettings());
        setMinRoomSettings(newUserPrefs.getMinRoomSettings());
        setMaxRoomSettings(newUserPrefs.getMaxRoomSettings());
        setMinFloorSettings(newUserPrefs.getMinFloorSettings());
        setMaxFloorSettings(newUserPrefs.getMaxFloorSettings());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public String[] getBlockSettings() {
        return blockSettings;
    }

    public void setBlockSettings(String[] blockSettings) {
        requireNonNull(blockSettings);
        this.blockSettings = blockSettings;
    }

    public int getMinRoomSettings() {
        return minRoomSettings;
    }

    public void setMinRoomSettings(int minRoomSettings) {
        requireNonNull(minRoomSettings);
        this.minRoomSettings = minRoomSettings;
    }

    public int getMaxRoomSettings() {
        return maxRoomSettings;
    }

    public void setMaxRoomSettings(int maxRoomSettings) {
        requireNonNull(maxRoomSettings);
        this.maxRoomSettings = maxRoomSettings;
    }

    public int getMinFloorSettings() {
        return minFloorSettings;
    }

    public void setMinFloorSettings(int minFloorSettings) {
        requireNonNull(minFloorSettings);
        this.minFloorSettings = minFloorSettings;
    }

    public int getMaxFloorSettings() {
        return maxFloorSettings;
    }

    public void setMaxFloorSettings(int maxFloorSettings) {
        requireNonNull(maxFloorSettings);
        this.maxFloorSettings = maxFloorSettings;
    }

    public Path getAddressBookFilePath() {
        return addressBookFilePath;
    }

    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        this.addressBookFilePath = addressBookFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return guiSettings.equals(o.guiSettings)
                && addressBookFilePath.equals(o.addressBookFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, addressBookFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal data file location : " + addressBookFilePath);
        sb.append("\nBlock Settings : " + blockSettings);
        sb.append("\nMin room Settings : " + minRoomSettings);
        sb.append("\nMax room Settings : " + maxRoomSettings);
        sb.append("\nMin floor Settings : " + minFloorSettings);
        sb.append("\nMax floor Settings : " + maxFloorSettings);
        return sb.toString();
    }

}
