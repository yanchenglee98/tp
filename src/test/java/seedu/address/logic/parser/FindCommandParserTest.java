package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_BLOCK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BLOCK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCommand;
import seedu.address.model.person.Block;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.model.person.RoomInBlockPredicate;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_emptyFields_throwsParseException() {
        assertParseFailure(parser, " " + PREFIX_NAME, FindCommand.MESSAGE_EMPTY_KEYWORD);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, INVALID_BLOCK, Block.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        NameContainsKeywordsPredicate namePredicate =
                new NameContainsKeywordsPredicate(Arrays.asList("Alice", "Bob"));
        List<Predicate<Person>> namePredicateList =
                Collections.singletonList(namePredicate);

        FindCommand expectedFindCommand =
                new FindCommand(namePredicateList);
        assertParseSuccess(parser, " " + PREFIX_NAME + "Alice Bob", expectedFindCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " " + PREFIX_NAME + " \n Alice \n \t Bob  \t", expectedFindCommand);

        // combined block and keywords find command
        FindCommand expectedCombinedFindCommand =
                new FindCommand(List.of(namePredicate, new RoomInBlockPredicate(new Block("B"))));

        // test parsing of multiple fields
        assertParseSuccess(parser, " " + PREFIX_NAME + " \n Alice \n \t Bob  \t"
                + " " + PREFIX_BLOCK + 'B', expectedCombinedFindCommand);
    }
}
