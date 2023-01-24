package iteratorsAndComparatorsExercise.movie;

import java.util.Comparator;

public class MovieNameComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie firtsMovie, Movie secondMovie) {
        return firtsMovie.getName().compareTo(secondMovie.getName());
    }
}
