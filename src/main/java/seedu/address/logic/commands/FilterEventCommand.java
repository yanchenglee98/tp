package seedu.address.logic.commands;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.Event;
import seedu.address.model.person.Person;

public class FilterEventCommand extends Command {
    public static final String MESSAGE_INVALID_EVENT = "The event index provided is invalid";
    public static final String COMMAND_WORD = "filter-event";

    private final Index eventIndex;

    public FilterEventCommand(Index eventIndex) {
        this.eventIndex = eventIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Event> eventList = model.getEventList();
        if (eventIndex.getZeroBased() >= eventList.size()) {
            throw new CommandException(MESSAGE_INVALID_EVENT);
        }

        // get event from event list
        Event event = eventList.get(eventIndex.getZeroBased());

        FilterEventPredicate predicate = new FilterEventPredicate(event.getAttendeesList());
        model.updateFilteredPersonList(predicate);
        return new CommandResult("Success");
    }

    private static class FilterEventPredicate implements Predicate<Person> {
        private final Set<Person> attendeeList;

        public FilterEventPredicate(Set<Person> attendeeList) {
            this.attendeeList = attendeeList;
        }

        @Override
        public boolean test(Person person) {
            return attendeeList.contains(person);
        }
    }
}
