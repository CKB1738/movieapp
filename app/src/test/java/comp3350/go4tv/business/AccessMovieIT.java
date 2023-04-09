package comp3350.go4tv.business;

import static junit.framework.TestCase.assertTrue;

import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.MoviePersistence;
import comp3350.go4tv.persistence.hsqldb.MoviePersistenceHSQLDB;
import comp3350.go4tv.utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

public class AccessMovieIT {

    private AccessMovie accessMovie;
    private File tempDB;
    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final MoviePersistence persistence = new MoviePersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessMovie = new AccessMovie(persistence);
    }

    @Test
    public void testGetMovie(){
        System.out.println("\nStart testing getMovies");
        Movie movie = new Movie("Plane", "After a heroic job of successfully landing his storm-damaged aircraft in a war zone, a fearless pilot finds himself between the agendas of multiple militias planning to take the plane and its passengers hostage.", 69);

        assertTrue(accessMovie.getMovie(movie.getName()).getName().equals(movie.getName()));
        assertTrue(accessMovie.getMovie(movie.getName()).getDescription().equals(movie.getDescription()));
        assertTrue(accessMovie.getMovie(movie.getName()).getRating() == movie.getRating());

    }

    @Test
    public void testGetListOfMovie(){
        System.out.println("\n Start testing getListOfMovie");
        assertTrue(accessMovie.getListOfMovie().size() == 5);
    }
    @After
    public void tearDown()
    {
        this.tempDB.delete();
    }
}
