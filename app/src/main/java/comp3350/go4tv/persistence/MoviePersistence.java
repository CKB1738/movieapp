package comp3350.go4tv.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.go4tv.objects.Movie;

public interface MoviePersistence {

    Movie getMovie(String movieName);

    List<Movie> getListOfMovie();


}
