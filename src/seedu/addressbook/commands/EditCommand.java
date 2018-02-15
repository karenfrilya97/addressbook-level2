package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalContactFieldException;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

/**
 * Edits a person's contact details in the address book.
 * The person is identified using it's last displayed index from the address book.
 */
public class EditCommand extends Command {
    public static final String COMMAND_WORD = "edit";

    private static String[] contactFields = {"name", "phone", "email", "address"};
    private static final String MESSAGE_INVALID_CONTACT_FIELD = "Contact field can only be either of the following: " + contactFields();

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits a person's contact details in the address book. "
            + "The person is idetinfied by the index number used in the last person listing.\n"
            + "Parameters: INDEX CONTACT_FIELD NEW_DETAIL\n"
            + "Example: " + COMMAND_WORD
            + " 1 name John Roe";

    public static final String MESSAGE_SUCCESS = "%1$s's %2$s has been changed from %3$s to %4$s";

    private String contactField;
    private String newDetail;
    private String oldDetail;
    private String targetName;

    public EditCommand (int targetVisibleIndex, String contactField, String newDetail) throws IllegalValueException, IllegalContactFieldException {
        super(targetVisibleIndex);
        this.contactField = contactField;
        this.newDetail = newDetail;
        ReadOnlyPerson target = getTargetPerson();
        targetName = target.getName().toString();
        editContact((Person) target);
    }

    private static String contactFields() {
        String contactFieldsString = new String();
        for (String contactField : contactFields) {
            contactFieldsString += contactField + " ";
        }
        return contactFieldsString.trim();
    }

    @Override
    public CommandResult execute() {
        try {
            return new CommandResult(String.format(MESSAGE_SUCCESS, targetName, contactField, oldDetail, newDetail));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
    }

    private void editContact(Person target) throws IllegalValueException, IllegalContactFieldException {
        switch (contactField) {
            case "name":
                oldDetail = target.getName().toString();
                target.setName(newDetail);
                break;
            case "phone":
                oldDetail = target.getPhone().toString();
                boolean isPrivate = target.getPhone().isPrivate();
                target.setPhone(newDetail, isPrivate);
                break;
            case "email":
                oldDetail = target.getEmail().toString();
                isPrivate = target.getEmail().isPrivate();
                target.setEmail(newDetail, isPrivate);
                break;
            case "address":
                oldDetail = target.getEmail().toString();
                isPrivate = target.getEmail().isPrivate();
                target.setAddress(newDetail, isPrivate);
                break;
            default:
                throw new IllegalContactFieldException(MESSAGE_INVALID_CONTACT_FIELD);
        }
    }
}

