package comp3350.go4tv.object;
import org.junit.Test;

import static org.junit.Assert.*;

import comp3350.go4tv.objects.Movie;

public class MovieTest {

    @Test
    public void testMovie(){


        System.out.println("\nStarting testMovie");
        Movie movie = new Movie("Inception","A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.",
                                    10);

        assertNotNull(movie);
        assertTrue("Inception".equals(movie.getName()));
        assertTrue("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.".equals(movie.getDescription()));
        assertTrue(10 == movie.getRating());

        System.out.println("Finishing testMovie");
    }


}
