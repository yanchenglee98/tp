package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.AttendeesList;
import seedu.address.model.event.Event;
import seedu.address.model.person.Person;
import seedu.address.model.person.exceptions.DuplicatePersonException;

import java.util.List;
import java.util.Set;

public class AssignCommand extends Command {

    public static final String COMMAND_WORD = "assign";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Assigns the person identified by the index number used in the displayed person list"
            + "to the specified event.\n"
            + "Parameters: INDEX (must be a positive integer) EVENT_NAME\n"
            + "Example: " + COMMAND_WORD + " 1 " + "Hall dinner";

    public static final String MESSAGE_INVALID_EVENT = "The event provided is invalid";
    public static final String MESSAGE_ASSIGN_PERSON_SUCCESS = "Assigned resident %s to %s";

    // index of person in person list to add
    // event that person will be added to
    // note that event is just a copy and not the direct reference to the event in the event list in model
    private final Index residentIndex;
    private final Index eventIndex;

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

        // add person to event's attendees list
        Set<Person> attendeesList = event.getAttendeesList();
        try {
            attendeesList.add(personToAdd);
        } catch (DuplicatePersonException e) {
            throw new CommandException("Duplicate person being added to event");
        }

        // TODO: update model's observable list of events similar to ModelManager#updateFilteredPersonList()
        // when updating observable list of persons

        return new CommandResult(String.format(MESSAGE_ASSIGN_PERSON_SUCCESS, personToAdd.getName(), event.getName()));
    }
}
