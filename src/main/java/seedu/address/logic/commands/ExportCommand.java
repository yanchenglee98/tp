package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Exports the email of all existing residents.
 */
public class ExportCommand extends Command {

    public static final String COMMAND_WORD = "export";
    public static final String MESSAGE_SUCCESS = "List of emails exported";
    public static final String FILENAME = "./data/hally.txt";
    public static final String DIRECTORY_NAME = "./data/";

    @Override
    public CommandResult execute(Model model) throws CommandException {

        File directory = new File(DIRECTORY_NAME);

        // checks if directory exists, else directory will be created
        if (!directory.exists()) {
            directory.mkdir();
        }

        try {
            FileWriter fw = new FileWriter(FILENAME);
            List<Person> list = model.getAddressBook().getPersonList();

            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    fw.write(list.get(i).getEmail().toString() + "\n");
                }
            }
            fw.close();
        } catch (IOException e) {
            throw new CommandException("File is missing");
        }

        return new CommandResult(MESSAGE_SUCCESS);
    }
}