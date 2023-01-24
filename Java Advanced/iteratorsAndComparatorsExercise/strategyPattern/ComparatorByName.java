package iteratorsAndComparatorsExercise.strategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if(first.getName().length()==second.getName().length()){
            char firstLetterFirstObject= first.getName().toLowerCase(Locale.ROOT).charAt(0);
            char firstLetterSecondObject= second.getName().toLowerCase(Locale.ROOT).charAt(0);
            return firstLetterFirstObject-firstLetterSecondObject;
        }
        return first.getName().length()-second.getName().length();
    }


}
