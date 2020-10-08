package seedu.address.logic.commands;

import static seedu.address.logic.parser.ExportCommandParser.INVALID_EXPORT_COMMAND;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Exports the email of all existing residents.
 */
public class ExportCommand extends Command {

    public static final String COMMAND_WORD = "export";
    public static final String MESSAGE_EMAIL_SUCCESS = "List of emails exported";
    public static final String MESSAGE_PHONE_SUCCESS = "List of phone numbers exported";
    public static final String FILENAME = "./data/hally.txt";
    public static final String DIRECTORY_NAME = "./data/";
    private final String extractType;

    /**
     * Creates an ExportCommand to handle the specified information
     */
    public ExportCommand(String type) {
        extractType = type;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        String message;
        switch (extractType) {
        case "email":
            handleEmail(model);
            message = MESSAGE_EMAIL_SUCCESS;
            break;
        case "phone":
            handlePhone(model);
            message = MESSAGE_PHONE_SUCCESS;
            break;
        default:
            throw new CommandException(INVALID_EXPORT_COMMAND);
        }

        return new CommandResult(message);
    }

    /**
     * Writes the email of all residents into a txt file
     * @param model {@code Model} which the command should operate on.
     * @throws CommandException if file IO is interrupted
     */
    private void handleEmail(Model model) throws CommandException {
        File directory = new File(DIRECTORY_NAME);

        // checks if directory exists, else directory will be created
        if (!directory.exists()) {
            directory.mkdir();
        }

        try {
            FileWriter fw = new FileWriter(FILENAME);
            List<Person> list = model.getAddressBook().getPersonList();

            if (list.size() > 0) {
                for (Person person : list) {
                    fw.write(person.getEmail().toString() + "\n");
                }
            }
            fw.close();
        } catch (IOException e) {
            throw new CommandException("File is missing");
        }
    }

    /**
     * Writes the phone numbers of all residents into a txt file
     * @param model {@code Model} which the command should operate on.
     * @throws CommandException If file IO is interrupted
     */
    private void handlePhone(Model model) throws CommandException {
        File directory = new File(DIRECTORY_NAME);

        // checks if directory exists, else directory will be created
        if (!directory.exists()) {
            directory.mkdir();
        }

        try {
            FileWriter fw = new FileWriter(FILENAME);
            List<Person> list = model.getAddressBook().getPersonList();

            if (list.size() > 0) {
                for (Person person : list) {
                    fw.write(person.getPhone().toString() + "\n");
                }
            }
            fw.close();
        } catch (IOException e) {
            throw new CommandException("File is missing");
        }
    }
}

