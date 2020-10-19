package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.storage.BlockSetting;

public class BlockSettingCard extends UiPart<Region> {
    private static final String FXML = "BlockSettingCard.fxml";

    private final BlockSetting blockSetting;

    @FXML
    private Label blockName;

    @FXML
    private Label level1Rooms;

    @FXML
    private Label level2Rooms;

    @FXML
    private Label level3Rooms;

    @FXML
    private Label level4Rooms;

    /**
     * Creates a {@code BlockSettingCard} with the given {@code BlockSetting}.
     */
    public BlockSettingCard(BlockSetting blockSetting) {
        super(FXML);
        this.blockSetting = blockSetting;

        blockName.setText(blockSetting.getBlockName());
        level1Rooms.setText(blockSetting.getLevel(1));
        level2Rooms.setText(blockSetting.getLevel(2));
        level3Rooms.setText(blockSetting.getLevel(3));
        level4Rooms.setText(blockSetting.getLevel(4));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof BlockSettingCard)) {
            return false;
        }

        // state check
        BlockSettingCard card = (BlockSettingCard) other;
        return blockSetting.equals(card.blockSetting);
    }
}
