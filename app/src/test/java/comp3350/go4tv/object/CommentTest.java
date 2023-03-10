package comp3350.go4tv.object;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.objects.User;
import comp3350.go4tv.objects.Comment;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class CommentTest {

    @Test
    public void testCommentGet(){

        System.out.println("\nStrating TestComment");
        User user = new User("Xin","umnie2@myumanitoba.ca","12345abc");
        Movie movie = new Movie("Inception","A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.",
                10);
        LocalDateTime time = LocalDateTime.now();
        Comment comment = new Comment("This is a good movie", movie,user, time);

        assertNotNull(comment);
        assertTrue(comment.getUser() == user);
        assertTrue(comment.getMovie() == movie);
        assertTrue(comment.getTime() == time);
        assertTrue("This is a good movie".equals(comment.getComment()));

        System.out.println("Finishing testCommentGet");

    }

    public void testCommentSet(){
        System.out.println("\nStarting TestCommentSet");

        System.out.println("\nStrating TestComment");
        User user = new User("Xin","umnie2@myumanitoba.ca","12345abc");
        Movie movie = new Movie("Inception","A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.",
              10);
        LocalDateTime time = LocalDateTime.now();
        Comment comment = new Comment("This is a good movie", movie,user, time);

        comment.setComment("I don't like it");
        assertTrue("I don't like it".equals(comment.getComment()));

        System.out.println("Finishing testCommentSet");

    }





}
