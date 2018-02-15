package seedu.addressbook.data.person;

import java.util.Comparator;

/**
 * A comparator class that compares 2 persons based on their names' ASCII values.
 */
public class PersonComparatorByName implements Comparator<ReadOnlyPerson>{

    @Override
    public int compare(ReadOnlyPerson person1, ReadOnlyPerson person2){
        String person1Name = person1.getName().toString();
        String person2Name = person2.getName().toString();
        return person1Name.compareTo(person2Name);
    }
}
