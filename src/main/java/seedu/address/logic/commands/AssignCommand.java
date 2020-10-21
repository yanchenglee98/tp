package seedu.address.logic.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.Event;
import seedu.address.model.person.Person;

public class AssignCommand extends Command {

    public static final String COMMAND_WORD = "assign";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Assigns the person identified by the index number used in the displayed person list"
            + "to the specified event.\n"
            + "Parameters: INDEX (must be a positive integer) EVENT_NAME\n"
            + "Example: " + COMMAND_WORD + " 1 " + "Hall dinner";

    public static final String MESSAGE_INVALID_EVENT = "The event provided is invalid";
    public static final String MESSAGE_ASSIGN_PERSON_SUCCESS = "Assigned resident %s to %s";
    public static final String MESSAGE_DUPLICATE_PERSON_ADDED = "Duplicate resident %s being added to event %s";

    // index of person in person list to add
    // event that person will be added to
    // note that event is just a copy and not the direct reference to the event in the event list in model
    private final Index residentIndex;
    private final Index eventIndex;

    /**
     * @param residentIndex index of the resident to be added
     * @param eventIndex index of the event to be modified
     */
    public AssignCommand(Index residentIndex, Index eventIndex) {
        this.residentIndex = residentIndex;
        this.eventIndex = eventIndex;
    }

    // an example of an assign command is assign 1 Hall dinner
    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();
        List<Event> eventList = model.getEventList();

        // get person from list based on index
        if (residentIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        if (eventIndex.getZeroBased() >= eventList.size()) {
            throw new CommandException(MESSAGE_INVALID_EVENT);
        }

        Person personToAdd = lastShownList.get(residentIndex.getZeroBased());

        // get event from list
        Event event = eventList.get(eventIndex.getZeroBased());

        // get attendee list from event
        Set<Person> attendeesList = new HashSet<>(event.getAttendeesList());

        // check if person to add is already in the event list
        if (attendeesList.contains(personToAdd)) {
            throw new CommandException(String.format(MESSAGE_DUPLICATE_PERSON_ADDED,
                    personToAdd.getName(),
                    event.getName()));
        }

        // add person to event's attendee list
        attendeesList.add(personToAdd);
        Event editedEvent = new Event(event.getName(), event.getDescription(), attendeesList);

        // TODO: update model's observable list of events similar to ModelManager#updateFilteredPersonList()
        // when updating observable list of persons
        model.setEvent(event, editedEvent);

        return new CommandResult(String.format(MESSAGE_ASSIGN_PERSON_SUCCESS, personToAdd.getName(), event.getName()));
    }
}
