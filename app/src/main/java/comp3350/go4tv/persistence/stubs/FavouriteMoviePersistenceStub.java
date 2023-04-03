package comp3350.go4tv.persistence.stubs;

import java.util.List;

import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.FavouriteMoviePersistence;

public class FavouriteMoviePersistenceStub implements FavouriteMoviePersistence {

    public FavouriteMoviePersistenceStub(){


    }
    @Override
    public Movie getMovie(String movieName) {
        return null;
    }

    @Override
    public List<Movie> getListOfMovie(String userName) {
        return null;
    }

    @Override
    public Movie addToList(String userName, String movieName) {
        return null;
    }
}
