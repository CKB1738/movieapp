package comp3350.go4tv.business;

import comp3350.go4tv.business.AccessUser;
import comp3350.go4tv.objects.User;
import comp3350.go4tv.persistence.stubs.UserPersistenceStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AccessUserTest {
    private AccessUser accessUser;

    @Before
    public void setUp(){
        this.accessUser = new AccessUser(new UserPersistenceStub());
    }

    @Test
    public void testGetUsers(){
        System.out.println("\nstarting test getUsers.");

        assertNotNull(accessUser);
        assertNotNull(accessUser.getUsers());
        System.out.println(accessUser.getUsers().size());
        assertTrue(accessUser.getUsers().size() == 5);

        System.out.println("End testing getUsers");
    }

    @Test
    public void testFindUser(){

        System.out.println("\nstarting test findUser.");
//        AccessUser accessUser = new AccessUser();

        assertNotNull(accessUser);
        User testUser = accessUser.findUser("Xin");
        assertNotNull(testUser);
        assertEquals("Xin", testUser.getUserName());
        System.out.println("End testing findUser");
    }


    @Test
    public void testVerifyUser(){

        System.out.println("\nstarting test verifyUser.");
//        AccessUser accessUser = new AccessUser();

        assertNotNull(accessUser);
        assertTrue(accessUser.verifyUser("Xin","12345abc"));
        assertTrue(accessUser.verifyUser("Arsh","123456abc"));
        assertTrue(accessUser.verifyUser("Het","1234567abc"));
        assertTrue(accessUser.verifyUser("Owl","12345678abc"));
        assertTrue(accessUser.verifyUser("Craig","123456789abc"));

        System.out.println("End testing verifyUser");

    }


    @Test
    public void testInsertUser(){

        System.out.println("\nstarting test insertUser.");
//        AccessUser accessUser = new AccessUser();
        User newUser = new User("testName","test@myumanitoba.ca","testPassword");
        User testUser = accessUser.insertUser(newUser);
        assertNotNull(testUser);
        assertTrue(accessUser.getUsers().size() == 6);

        User newUser1 = new User("Xin", "umnie2@myumanitoba.ca","12345abc");
        assertNull(accessUser.insertUser(newUser1));

        System.out.println("End testInsertUser");
    }

    @Test
    public void testUpdateUser(){

        System.out.println("\nstarting test updateUser.");
//        AccessUser accessUser = new AccessUser();

        assertNotNull(accessUser);

        User testUser = accessUser.findUser("Xin");

        assertNotNull(testUser);

        accessUser.updateUser("Xin","my new password", "my new email");

        User updatedUser = accessUser.findUser("Xin Nie");
        assertNotNull(updatedUser);
        assertTrue(updatedUser.getEmail().equals("my new email"));
        assertTrue(updatedUser.getPassword().equals("my new password"));
        accessUser.updateUser("Xin","12345abc", "umnie2@myumanitoba.ca");
        System.out.println("End test UpdateUser");

    }


}
