package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BLOCKROOM;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.BlockRoomCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Block;



public class BlockRoomCommandParser implements Parser<BlockRoomCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the BlockRoomCommand
     * and returns a BlockRoomCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public BlockRoomCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args,
                PREFIX_BLOCKROOM);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    BlockRoomCommand.MESSAGE_USAGE), ive);
        }

        String block = argMultimap.getValue(PREFIX_BLOCKROOM).orElse("");

        return new BlockRoomCommand(index, new Block(block));
    }
}
