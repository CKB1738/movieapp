package comp3350.go4tv.object;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import comp3350.go4tv.objects.Comment;
import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.objects.User;
public class UserTest {

    @Test
    public void testUserGet(){
        System.out.println("\nStarting testUserGet()");
        User user = new User("Xin","umnie2@myumanitoba.ca","12345abc");
        assertNotNull(user);

        assertTrue("Xin".equals(user.getUserName()));
        assertTrue("umnie2@myumanitoba.ca".equals(user.getEmail()));
        assertTrue("12345abc".equals(user.getPassword()));
        assertNotNull(user.getComments());


        System.out.println("finished testUserGet");
    }


    @Test
    public void testUserSet(){
        System.out.println("\nStarting testUserSet");

        User user = new User("Xin","umnie2@myumanitoba.ca","12345abc");

        user.setUserName("Nie");
        assertTrue("Nie".equals(user.getUserName()));
        user.setEmail("umnie3@myumanitoba.ca");
        assertTrue("umnie3@myumanitoba.ca".equals(user.getEmail()));
        user.setPassword("778899");
        assertTrue("778899".equals(user.getPassword()));

        System.out.println("Finishing testUserSet");

    }

    @Test
    public void testUserEqual(){
        User user1 = new User("Xin","umnie2@myumanitoba.ca","12345abc");

        User user2 = new User("Xin","umnie2@myumanitoba.ca","12345abc");

        assertTrue(user1.equals(user2));

    }


    @Test
    public void testUserComment(){
        User user = new User("Xin","umnie2@myumanitoba.ca","12345abc");
        Movie movie = new Movie("Inception","Leonardo Dicaprio", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.",
                2010,"Adventure");
        LocalDateTime time = LocalDateTime.now();
        Comment comment1 = new Comment("This is a good movie", movie,user, time);

        Comment comment2 = new Comment("I don't like this movie", movie,user,time);

        user.addComment(comment1);

        assertTrue(((List)user.getComments()).size() == 1);

        user.addComment(comment2);

        assertTrue(((List)user.getComments()).size() == 2);

        user.deleteComment(comment1);

        assertTrue(((List)user.getComments()).size() == 1);

        for(Comment comment : user.getComments()){
            assertTrue(comment.getComment().equals("I don't like this movie"));
        }

        System.out.println("Finishing testUserComment");




    }
}
