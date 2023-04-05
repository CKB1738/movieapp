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
        Movie movie = new Movie("Inception","A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.",
                10);
        assertTrue("Inception".equals(movie.getName()));
        assertTrue("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.".equals(movie.getDescription()));
        assertTrue(10 == movie.getRating());

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
