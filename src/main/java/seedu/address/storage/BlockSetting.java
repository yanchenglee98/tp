package seedu.address.storage;

/**
 * Represents a block with its settings.
 */
public class BlockSetting {
    private final String blockName;

    public BlockSetting(String blockName) {
        this.blockName = blockName;
    }

    public String getBlockName() {
        return blockName;
    }

    /**
     * Returns a string containing the rooms present on that level.
     * @param level the level to retrieve for.
     * @return Range of rooms present on that level.
     */
    public String getLevel(int level) {
        return "Level " + level + ": " + level + "00 to " + level + "20";
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof BlockSetting)) {
            return false;
        }

        BlockSetting otherBlockSetting = (BlockSetting) other;
        return otherBlockSetting.getBlockName().equals(getBlockName());
    }
}
