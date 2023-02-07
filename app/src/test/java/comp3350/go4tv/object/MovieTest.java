package comp3350.go4tv.object;
import org.junit.Test;

import static org.junit.Assert.*;

import comp3350.go4tv.objects.Movie;

public class MovieTest {

    @Test
    public void testMovie(){


        System.out.println("\nStarting testMovie");
        Movie movie = new Movie("Inception","Leonardo Dicaprio", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.",
                                    2010,"Adventure");

        assertNotNull(movie);
        assertTrue("Inception".equals(movie.getName()));
        assertTrue("Leonardo Dicaprio".equals(movie.getPeople()));
        assertTrue("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.".equals(movie.getOverview()));
        assertTrue(2010 == movie.getYear());
        assertTrue("Adventure".equals(movie.getGenre()));

        System.out.println("Finishing testMovie");
    }


}
