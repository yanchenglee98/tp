package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AssignCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventName;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class AssignCommandParser implements Parser<AssignCommand> {
    private static final int RESIDENT_INDEX = 0;
    private static final int EVENT_INDEX = 1;

    @Override
    public AssignCommand parse(String args) throws ParseException {
        try {
            // assign 1 1
            String[] split = args.stripLeading().split(" ", 2); // { 1, 1 }
            Index residentIndex = ParserUtil.parseIndex(split[RESIDENT_INDEX]);
            Index eventIndex = ParserUtil.parseIndex(split[EVENT_INDEX]);

            return new AssignCommand(residentIndex, eventIndex);
        } catch (ParseException | IndexOutOfBoundsException e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AssignCommand.MESSAGE_USAGE), e);
        }
    }
}
