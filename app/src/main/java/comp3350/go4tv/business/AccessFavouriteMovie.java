package comp3350.go4tv.business;

import java.util.List;

import comp3350.go4tv.application.Service;
import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.FavouriteMoviePersistence;
import comp3350.go4tv.persistence.hsqldb.FavouriteMoviePersistenceHSQLDB;

public class AccessFavouriteMovie {
    private FavouriteMoviePersistence favouriteMoviePersistence = null;

    private Movie movie;

    private List<Movie> movies;


    public AccessFavouriteMovie(){
        favouriteMoviePersistence = Service.getFavouriteMoviePersistence();
        movie = null;
        movies = null;
    }

    public AccessFavouriteMovie(FavouriteMoviePersistence favouriteMoviePersistence){
        this();
        this.favouriteMoviePersistence = favouriteMoviePersistence;
    }

    public Movie getMovie(String movieName){
        return favouriteMoviePersistence.getMovie(movieName);
    }

    public List<Movie> getListOfMovies(String username){
        return favouriteMoviePersistence.getListOfMovie(username);
    }

    public Movie addToList(String username,String movieName){
        return favouriteMoviePersistence.addToList(username,movieName);
    }

}
