package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.Event;
import seedu.address.model.person.Person;

import java.util.List;

public class AssignCommand extends Command {

    public static final String COMMAND_WORD = "assign";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Assigns the person identified by the index number used in the displayed person list"
            + "to the specified event.\n"
            + "Parameters: INDEX (must be a positive integer) EVENT_NAME\n"
            + "Example: " + COMMAND_WORD + " 1" + "Hall dinner";

    public static final String MESSAGE_INVALID_EVENT = "The event provided is invalid";
    public static final String MESSAGE_ASSIGN_PERSON_SUCCESS = "Assigned Person %s to %s";

    // index of person in person list to add
    // event that person will be added to
    // note that event is just a copy and not the direct reference to the event in the event list in model
    private final Index index;
    private final Event event;

    public AssignCommand(Index index, Event event) {
        this.index = index;
        this.event = event;
    }

    // an example of an assign command is assign 1 Hall dinner
    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();
        List<Event> eventList = model.getEventList();

        // get person from list based on index
        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToAdd = lastShownList.get(index.getZeroBased());

        // get event from list
        int eventIndex = eventList.indexOf(event);

        if (eventIndex < 0) {
            throw new CommandException(MESSAGE_INVALID_EVENT);
        }

        // get original event from event list
        Event originalEvent = eventList.get(eventIndex);

        // TODO: add person to event similar to: originalEvent.addPerson(personToAdd);

        return new CommandResult(String.format(MESSAGE_ASSIGN_PERSON_SUCCESS, personToAdd, originalEvent));
    }
}
