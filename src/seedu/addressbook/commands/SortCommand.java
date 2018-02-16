package seedu.addressbook.commands;

import java.util.List;
import seedu.addressbook.data.person.ReadOnlyPerson;


/**
 * Sorts the address book based on persons' names in alphabetical order (based on ASCII value).
 * Lists all persons in the address book after sorting.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts the address book based on persons' names in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Address book has been sorted!";

    @Override
    public CommandResult execute() {
        addressBook.sort();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(MESSAGE_SUCCESS, allPersons);
    }
}
