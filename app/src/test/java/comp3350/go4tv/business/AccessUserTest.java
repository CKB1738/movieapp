package comp3350.go4tv.business;

import comp3350.go4tv.objects.User;
import comp3350.go4tv.persistence.UserPersistence;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


public class AccessUserTest {
    private AccessUser accessUser;
    private UserPersistence userPersistence;
    @Before
    public void setUp(){

        this.userPersistence = mock(UserPersistence.class);
        this.accessUser = new AccessUser(userPersistence);

    }

    @Test
    public void testGetUsers(){
        System.out.println("\nstarting test getUsers.");

        final List<User> users = new ArrayList<>();
        users.add(new User("testUser","testUser@myumaniotba.ca","abc123"));

        when(userPersistence.getUserList()).thenReturn(users);

        final User user = accessUser.getUsers().get(0);

        assertNotNull(user);
        assertTrue(user.getUserName().equals("testUser"));
        verify(userPersistence).getUserList();
        System.out.println("End testing getUsers");
    }

    @Test
    public void testFindUser(){

        System.out.println("\nstarting test findUser.");

        when(userPersistence.findUser("testUser")).thenReturn(new User("testUser","testUser@myumanitoba.ca","abc123"));



        User testUser = accessUser.findUser("testUser");
        assertNotNull(testUser);
        assertEquals("testUser", testUser.getUserName());
        verify(userPersistence).findUser("testUser");

        System.out.println("End testing findUser");
    }


    @Test
    public void testVerifyUser(){

        System.out.println("\nstarting test verifyUser.");

        when(userPersistence.verifyUser("testUser","abc123")).thenReturn(true);

        assertTrue(accessUser.verifyUser("testUser","abc123"));
        verify(userPersistence).verifyUser("testUser","abc123");

        System.out.println("End testing verifyUser");

    }


    @Test
    public void testInsertUser(){

        System.out.println("\nstarting test insertUser.");


        User newUser = new User("testUser","testUser@myumanitoba.ca","abc123");
        when(userPersistence.insertUser(newUser)).thenReturn(newUser);

        User testUser = accessUser.insertUser(newUser);
        assertNotNull(testUser);
        assertTrue(testUser.getUserName().equals("testUser"));
        verify(userPersistence).insertUser(newUser);



        System.out.println("End testInsertUser");
    }

    @Test
    public void testUpdateUser(){

        System.out.println("\nstarting test updateUser.");

        when(userPersistence.updateUser("testUser", "aaa","aaa@umanitoba.ca")).thenReturn(new User("testUser","aaa@umanitoba.ca","aaa"));
        User testUser = accessUser.updateUser("testUser", "aaa","aaa@umanitoba.ca");
        assertNotNull(testUser);
        assertTrue(testUser.getEmail().equals("aaa@umanitoba.ca"));
        verify(userPersistence).updateUser("testUser", "aaa","aaa@umanitoba.ca");
        System.out.println("End test UpdateUser");

    }


}
