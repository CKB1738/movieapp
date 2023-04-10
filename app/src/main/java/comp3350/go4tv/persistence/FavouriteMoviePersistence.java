package comp3350.go4tv.persistence;

import java.util.List;

import comp3350.go4tv.objects.Movie;

public interface FavouriteMoviePersistence {

    Movie getMovie(String movieName);

    List<Movie> getListOfMovie(String userName);

    Movie addToList(String userName, String movieName);
}
