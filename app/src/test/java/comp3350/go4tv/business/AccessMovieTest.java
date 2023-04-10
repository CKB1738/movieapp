package comp3350.go4tv.business;


import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.MoviePersistence;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccessMovieTest {

    private AccessMovie accessMovie;
    private MoviePersistence moviePersistence;
    @Before
    public void setUp() throws IOException {
        moviePersistence = mock(MoviePersistence.class);
        accessMovie = new AccessMovie(moviePersistence);

    }

    @Test
    public void testGetMovie(){
        System.out.println("\nStart testing getMovies");
        final Movie movie;
        final List<Movie> movies = new ArrayList<>();
        Movie testMovie = new Movie("testMovie","This is test movie.", 10);
        when(accessMovie.getMovie("testMovie")).thenReturn(testMovie);

        movie = accessMovie.getMovie("testMovie");

        assertNotNull("Test Movie should not be null",movie);
        assertTrue(movie.getName().equals("testMovie"));
        verify(moviePersistence).getMovie("testMovie");
        System.out.println("\nEnd of testing getMovie");
    }

    @Test
    public void testGetListOfMovie(){
        System.out.println("\n Start testing getListOfMovie");

        final List<Movie> movies = new ArrayList<>();
        final Movie movie;
        Movie testMovie1 = new Movie("testMovie1","This is test movie1.", 10);
        Movie testMovie2 = new Movie("testMovie2","This is test movie2.", 10);
        movies.add(testMovie1);
        movies.add(testMovie2);
        when(moviePersistence.getListOfMovie()).thenReturn(movies);
        movie = accessMovie.getListOfMovie().get(0);
        assertNotNull("First movie should not be null",movie);
        assertTrue(movie.getName().equals("testMovie1"));
        verify(moviePersistence).getListOfMovie();
        System.out.println("\nEnd of test getListOfMovie");
    }

}
