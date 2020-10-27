package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_BLOCK;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_STUDENT_GROUP_DESC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BLOCK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENT_GROUP;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCommand;
import seedu.address.model.person.Block;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.model.person.RoomInBlockPredicate;
import seedu.address.model.person.StudentGroupPredicate;
import seedu.address.model.studentgroup.StudentGroup;

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
        assertParseFailure(parser, INVALID_BLOCK, Block.getMessageConstraints());
        assertParseFailure(parser, INVALID_STUDENT_GROUP_DESC, StudentGroup.MESSAGE_CONSTRAINTS);
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

        // combined block, name and student group keywords find command
        Set<StudentGroup> studentGroupSet = new HashSet<>();
        studentGroupSet.add(new StudentGroup("badminton"));
        FindCommand expectedCombinedFindCommand =
                new FindCommand(List.of(new RoomInBlockPredicate(new Block("B")), namePredicate,
                    new StudentGroupPredicate(studentGroupSet)));

        // test parsing of multiple fields
        assertParseSuccess(parser, " " + PREFIX_NAME + " \n Alice \n \t Bob  \t"
                + " " + PREFIX_BLOCK + 'B' + " " + PREFIX_STUDENT_GROUP + "badminton", expectedCombinedFindCommand);
    }
}
