package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * todo
 * 1) update DG/UG with rationale for exporting to txt
 *      reason: .txt is more user friendly as not everyone know about json
 *      and also every OS is able to open .txt files
 * 2) update MESSAGE_SUCCESS variable with String.format("List of %s exported, extractType)
 * 3) improve error message
 * 4) run bash ./config/travis/run-checks.sh
 *      currently failing /r/n new line but thats because
 *      need to stage changes through git add .
 *      so no changes required for new line
 */

/**
 * Exports the email of all existing residents.
 */
public class ExportCommand extends Command {

    public static final String COMMAND_WORD = "export";
    public static final String MESSAGE_SUCCESS = "List of emails exported";
    public static final String FILENAME = "./data/hally.txt";
    public static final String DIRECTORY_NAME = "./data/";
    private final String extractType;

    /**
     * Creates an ExportCommand to handle the specified type
     */
    public ExportCommand(String type) {
        extractType = type;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        switch (extractType) {
        case "email":
            handleEmail(model);
            break;
        case "phone":
            handlePhone(model);
            break;
        default:
            throw new CommandException("Invalid export format");
        }

        return new CommandResult(MESSAGE_SUCCESS);
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

