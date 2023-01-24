package iteratorsAndComparatorsExercise.movie;

import java.util.Comparator;

public class MovieBudgetComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie first, Movie second) {
        return Integer.compare(first.getBudget(), second.getBudget());
    }
}
