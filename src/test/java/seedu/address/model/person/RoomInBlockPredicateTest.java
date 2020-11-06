package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_BLOCK_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_BLOCK_BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class RoomInBlockPredicateTest {

    @Test
    public void equals() {
        Block firstBlock = new Block(VALID_BLOCK_AMY);
        Block secondBlock = new Block(VALID_BLOCK_BOB);

        RoomInBlockPredicate firstPredicate =
                new RoomInBlockPredicate(firstBlock);
        RoomInBlockPredicate secondPredicate =
                new RoomInBlockPredicate(secondBlock);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        RoomInBlockPredicate firstPredicateCopy =
                new RoomInBlockPredicate(firstBlock);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_matriculationNumber_returnsTrue() {
        // same block -> returns true
        RoomInBlockPredicate predicate =
                new RoomInBlockPredicate(new Block(VALID_BLOCK_AMY));
        assertTrue(predicate
                .test(new PersonBuilder().withBlock(VALID_BLOCK_AMY).build()));

        // different block -> returns false
        predicate = new RoomInBlockPredicate(new Block(VALID_BLOCK_BOB));
        assertFalse(predicate
                .test(new PersonBuilder().withBlock(VALID_BLOCK_AMY).build()));
    }

}
