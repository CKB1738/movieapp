package comp3350.go4tv.object;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
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

        User user = mock(User.class);

        when(user.getUserName()).thenReturn("Xin");
        when(user.getEmail()).thenReturn("umnie2@myumanitoba.ca");
        when(user.getPassword()).thenReturn("abc123");


        assertTrue("Xin".equals(user.getUserName()));
        assertTrue("umnie2@myumanitoba.ca".equals(user.getEmail()));
        assertTrue("abc123".equals(user.getPassword()));


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

}
