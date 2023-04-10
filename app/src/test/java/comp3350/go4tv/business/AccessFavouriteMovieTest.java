package comp3350.go4tv.business;


import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.FavouriteMoviePersistence;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


public class AccessFavouriteMovieTest {

    private AccessFavouriteMovie accessFavouriteMovie;
    private FavouriteMoviePersistence favouriteMoviePersistence;

    @Before
    public void setUp(){
        this.favouriteMoviePersistence= mock(FavouriteMoviePersistence.class);
        this.accessFavouriteMovie = new AccessFavouriteMovie(favouriteMoviePersistence);

    }

    @Test
    public void testGetMovie(){
        System.out.println("\nStart test getMovie");
        final Movie movie;
        when(accessFavouriteMovie.getMovie("TestMovie")).thenReturn(new Movie("TestMovie","This is test Movie",10));
        movie = accessFavouriteMovie.getMovie("TestMovie");
        assertNotNull(movie);
        assertTrue(movie.getName().equals("TestMovie"));
        verify(favouriteMoviePersistence).getMovie("TestMovie");
        System.out.println("\nEnd of test getMovie");

    }

    @Test
    public void testGetListOfMovie(){

        System.out.println("\nStart test getListOfMovie");
        final List<Movie> movies = new ArrayList<>();
        final Movie movie;
        movies.add(new Movie("TestMovie","This is test Movie",10));
        when(favouriteMoviePersistence.getListOfMovie("testUser")).thenReturn(movies);
        movie = accessFavouriteMovie.getListOfMovies("testUser").get(0);
        assertNotNull(movie);
        assertTrue(movie.getName().equals("TestMovie"));
        verify(favouriteMoviePersistence).getListOfMovie("testUser");
        System.out.println("\nEnd of testing getListOfMovie");
    }

    @Test
    public void testAddToList(){
        System.out.println("Start test addToList");
        final Movie movie;
        when(favouriteMoviePersistence.addToList("testUser","testMovie")).thenReturn(new Movie("TestMovie","This is test Movie",10));

        movie = accessFavouriteMovie.addToList("testUser","testMovie");
        assertNotNull(movie);
        assertTrue(movie.getName().equals("TestMovie"));
        verify(favouriteMoviePersistence).addToList("testUser","testMovie");
    }

}
