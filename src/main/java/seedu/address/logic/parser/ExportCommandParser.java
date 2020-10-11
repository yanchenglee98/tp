package seedu.address.logic.parser;

import static seedu.address.logic.commands.ExportCommand.MESSAGE_USAGE;

import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class ExportCommandParser implements Parser<ExportCommand> {
    private static final int MIN_ARGUMENTS = 2;
    private static final int TYPE_INDEX = 1;

    /**
     * Parses the given {@code String} of arguments in the context of the ExportCommand
     * and returns an ExportCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public ExportCommand parse(String args) throws ParseException {
        String[] split = args.split(" ");

        if (split.length < MIN_ARGUMENTS) {
            throw new ParseException(MESSAGE_USAGE);
        } else {
            // make it case insensitive
            String type = split[TYPE_INDEX].toLowerCase();

            return new ExportCommand(type);
        }

    }
}
