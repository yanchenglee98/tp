package seedu.address.logic.parser;

import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class ExportCommandParser implements Parser<ExportCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the RemarkCommand
     * and returns an RemarkCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ExportCommand parse(String args) throws ParseException {
        String[] split = args.split(" ");

        if (split.length < 2) {
            throw new ParseException("Export missing parameter: email or phone");
        } else {
            // make it case insensitive
            String type = split[1].toLowerCase();

            return new ExportCommand(type);
        }

    }
}
