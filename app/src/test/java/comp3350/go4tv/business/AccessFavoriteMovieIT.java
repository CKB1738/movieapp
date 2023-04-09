package comp3350.go4tv.business;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.FavouriteMoviePersistence;
import comp3350.go4tv.persistence.MoviePersistence;
import comp3350.go4tv.persistence.hsqldb.FavouriteMoviePersistenceHSQLDB;
import comp3350.go4tv.persistence.hsqldb.MoviePersistenceHSQLDB;
import comp3350.go4tv.utils.TestUtils;

public class AccessFavoriteMovieIT {
    private AccessFavouriteMovie accessFavouriteMovie;
    private File tempDB;
    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final FavouriteMoviePersistence persistence = new FavouriteMoviePersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessFavouriteMovie = new AccessFavouriteMovie(persistence);
    }
    @Test
    public void testGetMovie(){
        System.out.println("\nStart testing getMovies");
        Movie movie = new Movie("Plane", "After a heroic job of successfully landing his storm-damaged aircraft in a war zone, a fearless pilot finds himself between the agendas of multiple militias planning to take the plane and its passengers hostage.", 69);
        System.out.println(accessFavouriteMovie.getMovie("Plane").getName());
        assertEquals(accessFavouriteMovie.getMovie(movie.getName()).getName(), movie.getName());
        assertEquals(accessFavouriteMovie.getMovie(movie.getName()).getDescription(), movie.getDescription());
        assertEquals(accessFavouriteMovie.getMovie(movie.getName()).getRating(), movie.getRating());

    }

    @Test
    public void testGetListOfMovies(){
        System.out.println("\nStart testing getListOfMovies");
        String username = "Xin";
        List<Movie> movieList = accessFavouriteMovie.getListOfMovies(username);
        assertTrue(movieList.size() == 1);
    }

    @Test
    public void testAddToList(){
        String username = "Xin";
        String moviename = "Little Dixie";
        List<Movie> movieList = accessFavouriteMovie.getListOfMovies(username);
        int numberOfMovies = movieList.size();      //get the current number of movies
        accessFavouriteMovie.addToList(username, moviename);

        assertTrue(accessFavouriteMovie.getListOfMovies(username).size() == numberOfMovies + 1);

    }


    @After
    public void tearDown()
    {
        this.tempDB.delete();
    }
}
