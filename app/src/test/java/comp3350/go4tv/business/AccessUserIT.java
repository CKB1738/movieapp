package comp3350.go4tv.business;

import comp3350.go4tv.business.AccessUser;
import comp3350.go4tv.objects.User;
import comp3350.go4tv.persistence.UserPersistence;
import comp3350.go4tv.persistence.hsqldb.UserPersistenceHSQLDB;
import comp3350.go4tv.utils.TestUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;


public class AccessUserIT {
    private AccessUser accessUser;
    File tempDB;
    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final UserPersistence persistence = new UserPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessUser = new AccessUser(persistence);
    }

    @Test
    public void testGetUsers(){
        System.out.println("\nstarting test getUsers.");
        assertEquals(accessUser.getUsers().size(), 6);
        System.out.println("End testing getUsers");
    }

    @Test
    public void testFindUser(){
        System.out.println("\nstarting test findUser.");
        User testUser = accessUser.findUser("Xin");
        assertEquals("Xin", testUser.getUserName());
        System.out.println("End testing findUser");
    }


    @Test
    public void testVerifyUser(){
        System.out.println("\nstarting test verifyUser.");
        assertTrue(accessUser.verifyUser("Xin","abc123"));
        assertTrue(accessUser.verifyUser("Arsh","123456abc"));
        assertTrue(accessUser.verifyUser("Het","12345678abc"));
        assertTrue(accessUser.verifyUser("Owl","12345678abc"));
        assertTrue(accessUser.verifyUser("Craig","123456789abc"));
        System.out.println("End testing verifyUser");
    }


    @Test
    public void testInsertUser(){
        System.out.println("\nstarting test insertUser.");
        User newUser = new User("testName","test@myumanitoba.ca","testPassword");
        User testUser = accessUser.insertUser(newUser);
        assertTrue(accessUser.getUsers().size() == 7);
        System.out.println("End testInsertUser");
    }

    @Test
    public void testUpdateUser(){
        System.out.println("\nstarting test updateUser.");
        User testUser = accessUser.findUser("Xin");
        accessUser.updateUser("Xin","my new password", "my new email");
        User updatedUser = accessUser.findUser("Xin");
        assertTrue(updatedUser.getEmail().equals("my new email"));
        assertTrue(updatedUser.getPassword().equals("my new password"));
        accessUser.updateUser("Xin","12345abc", "umnie2@myumanitoba.ca");
        System.out.println("End test UpdateUser");
    }
    @After
    public void tearDown() {
        this.tempDB.delete();
    }


}
