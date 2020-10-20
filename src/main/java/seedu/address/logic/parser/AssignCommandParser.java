package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AssignCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.Event;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class AssignCommandParser implements Parser<AssignCommand> {
    private static final int INDEX_POS = 0;
    private static final int EVENT_POS = 1;

    @Override
    public AssignCommand parse(String args) throws ParseException {
        try {
            String[] split = args.stripLeading().split(" ", 2); // { "1", "hall dinner" }
            String indexArgs = split[INDEX_POS];
            String eventName = split[EVENT_POS];

            Index index = ParserUtil.parseIndex(indexArgs);
            Event event = new Event(eventName);

            return new AssignCommand(index, event);
        } catch (ParseException | IndexOutOfBoundsException e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AssignCommand.MESSAGE_USAGE), e);
        }
    }
}
