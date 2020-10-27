package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.FilterEventCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class FilterEventCommandParser implements Parser<FilterEventCommand> {
    @Override
    public FilterEventCommand parse(String userInput) throws ParseException {
        try {
            Index eventIndex = ParserUtil.parseIndex(userInput);
            return new FilterEventCommand(eventIndex);
        } catch (ParseException e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterEventCommand.MESSAGE_USAGE), e);
        }
    }
}
