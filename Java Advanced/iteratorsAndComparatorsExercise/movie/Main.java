package iteratorsAndComparatorsExercise.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movieList=new ArrayList<>();
        Movie movie1=new Movie("Titanik",8000000,9);
        Movie movie2=new Movie("Asterix",80000,7);
        Movie movie3=new Movie("Otto",500000,5);
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);

       // MovieBudgetComparator budgetComparator=new MovieBudgetComparator();
        Collections.sort(movieList, new MovieBudgetComparator());
     //   MovieNameComparator nameComparator=new MovieNameComparator();
   //     Collections.sort(movieList, nameComparator);
  //      Collections.sort(movieList, budgetComparator);
        //Collections.sort(movieList);

        for (Movie movie : movieList) {
            System.out.println(movie);
        }
    }
}
