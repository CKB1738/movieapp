package comp3350.go4tv.business;

import comp3350.go4tv.business.AccessMovie;
import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.MoviePersistence;
import comp3350.go4tv.persistence.hsqldb.MoviePersistenceHSQLDB;
import comp3350.go4tv.persistence.stubs.MoviePersistenceStub;
import comp3350.go4tv.utils.TestUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

public class AccessMovieTest {

    private AccessMovie accessMovie;
    @Before
    public void setUp() throws IOException {
        final MoviePersistence persistence = new MoviePersistenceStub();

    }

    @Test
    public void testGetMovie(){
        System.out.println("\nStart testing getMovies");

        assertNotNull(accessMovie);
        assertNotNull(accessMovie.getMovie("Plane"));

    }

    @Test
    public void testGetListOfMovie(){
        System.out.println("\n Start testing getListOfMovie");

        assertNotNull(accessMovie);
        assertNotNull(accessMovie.getListOfMovie());
        assertTrue(accessMovie.getListOfMovie().size() == 5);
    }

}
