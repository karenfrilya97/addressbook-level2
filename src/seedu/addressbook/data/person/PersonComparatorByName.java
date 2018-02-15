package seedu.addressbook.data.person;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<ReadOnlyPerson>{
    @Override
    public int compare(ReadOnlyPerson person1, ReadOnlyPerson person2){
        String person1Name = person1.getName().toString();
        String person2Name = person2.getName().toString();
        return person1Name.compareTo(person2Name);
    }
}
