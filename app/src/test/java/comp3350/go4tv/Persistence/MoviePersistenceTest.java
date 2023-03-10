package comp3350.go4tv.Persistence;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.stubs.MoviePersistenceStub;

public class MoviePersistenceTest {
    @Test
    public void testGetMovie(){
        System.out.println("\nStart testing getmovie()");

        MoviePersistenceStub moviePersistenceStub = new MoviePersistenceStub();
        Movie test = moviePersistenceStub.getMovie("Plane");
        assertNotNull(test);


    }


    @Test
    public void testGetListOfMovie(){
        System.out.println("\nStart testing getListOfMovie()");

        MoviePersistenceStub moviePersistenceStub = new MoviePersistenceStub();
        List<Movie> test = moviePersistenceStub.getListOfMovie();
        assertNotNull(test);
        assertTrue(test.size() == 5);
    }

}
