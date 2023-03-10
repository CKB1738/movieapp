package comp3350.go4tv.business;

import java.util.Collections;
import java.util.List;

import comp3350.go4tv.application.Service;
import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.MoviePersistence;
import comp3350.go4tv.persistence.UserPersistence;

public class AccessMovie {

    private MoviePersistence moviePersistence = null;
    private Movie movie;
    private List<Movie> movies;


    public AccessMovie(){
        moviePersistence = Service.getMoviePersistence();
        movie = null;
        movies = null;
    }

    public AccessMovie(final MoviePersistence moviePersistence){
        this();
        this.moviePersistence = moviePersistence;

    }

    public Movie getMovie(String movieName){
        return moviePersistence.getMovie(movieName);

    }

    public List<Movie> getListOfMovie(){
        return moviePersistence.getListOfMovie();
    }
}
