package iteratorsAndComparatorsExercise.movie;

public class Movie implements Comparable<Movie> {
    private String name;
    private int budget;
    private int rating;

    public Movie(String name, int budget, int rating) {
        this.name = name;
        this.budget = budget;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Movie anotherMovie) {

        return this.rating-anotherMovie.getRating();
    }

    @Override
    public String toString() {
        return this.getName()+ " Rating "+ this.getRating()+" Budget: "+this.getBudget();
    }
}
