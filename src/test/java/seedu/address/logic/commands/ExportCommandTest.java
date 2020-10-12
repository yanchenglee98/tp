package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.ExportCommand.MESSAGE_PHONE_SUCCESS;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static seedu.address.logic.commands.ExportCommand.MESSAGE_EMAIL_SUCCESS;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ExportCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_exportEmail_exportSuccessful() throws CommandException {
        CommandResult commandResult = new ExportCommand("email").execute(model);

        assertEquals(MESSAGE_EMAIL_SUCCESS, commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_exportPhone_exportSuccessful() throws CommandException {
        CommandResult commandResult = new ExportCommand("phone").execute(model);

        assertEquals(MESSAGE_PHONE_SUCCESS, commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_invalidType_throwsCommandException() {
        ExportCommand exportCommand = new ExportCommand("a");

        assertThrows(CommandException.class, ExportCommand.MESSAGE_USAGE, () -> exportCommand.execute(model));
    }
}
