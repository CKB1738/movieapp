package comp3350.go4tv.Persistence;

import static org.junit.Assert.*;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import comp3350.go4tv.objects.User;
import comp3350.go4tv.persistence.stubs.UserPersistenceStub;

public class UserPersistenceTest {

    @Test
    public void verifyUserTest(){
        System.out.println("Starting verifyUserTest");


        String name = "Craig";
        String password = "123456789abc";
        String email = "craig@myumanitoba.ca";

        User user = new User(name, email, password);
        UserPersistenceStub userPersistenceStub = new UserPersistenceStub();
        assertTrue(userPersistenceStub.verifyUser(user.getUserName(), user.getPassword()));
        assertTrue(userPersistenceStub.verifyUser(name,password));

        System.out.println("Finished verifyUserTest");
    }


    @Test
    public void insertUserTest(){
        System.out.println("Starting insertUserTest");

        User newUser = new User("Emil", "emil123@gmail.com", "emil12345");
        User user2 = new User("Craig", "craig@myumanitoba.ca", "123456789abc");
        UserPersistenceStub userPersistenceStub1 = new UserPersistenceStub();
        assertNotNull(userPersistenceStub1.insertUser(newUser));
        assertNull(userPersistenceStub1.insertUser(user2));
        userPersistenceStub1.deleteUser(user2);

        System.out.println("Finished insertUserTest");
    }

    @Test
    public void updateUserTest(){
        System.out.println("----------Starting updateUserTest----------\n");

        User user = new User("Calvin", "calvin@myumanitoba.ca", "123456abc");
        String newUsername = "batman";
        String newPassword = "sesame12345";
        String newEmail = "kwame@gmail.com";
        UserPersistenceStub userPersistenceStub = new UserPersistenceStub();
        userPersistenceStub.insertUser(user);
        assertNotNull(userPersistenceStub.updateUser(user.getUserName(),newUsername, newPassword, newEmail));
        System.out.println("Username change successful\n");

        System.out.println("----------Finished updateUserTest----------\n");
    }

    @Test
    public void getUserInfoTest(){
        User user = new User("Lawry", "lawry@gmail.com", "12345lawry");
        UserPersistenceStub userPersistenceStub = new UserPersistenceStub();
        userPersistenceStub.insertUser(user);
        assertNotNull(userPersistenceStub.getUserInfo(user));
    }


    @Test
    public void getUserListTest(){
        User user = new User("kwame", "kwame@gmail.com", "kwame12345");
        UserPersistenceStub userPersistenceStub = new UserPersistenceStub();
        assertNotNull(userPersistenceStub.getUserList());
    }

    @Test
    public void deleteUserTest(){
        User user = new User("kwame", "kwame@gmail.com", "kwame12345");
        User newUser = new User("Emil", "emil123@gmail.com", "emil12345");
        UserPersistenceStub userPersistenceStub = new UserPersistenceStub();
        userPersistenceStub.insertUser(user);
        userPersistenceStub.insertUser(newUser);
        userPersistenceStub.deleteUser(user);
        assertEquals("size should be 5", 6, userPersistenceStub.getUserList().size());

        System.out.println("User deleted");

    }


    @Test
    public void findUserTest(){
        User user = new User("kwame", "kwame@gmail.com", "kwame12345");
        String username = "kwame";
        UserPersistenceStub userPersistenceStub = new UserPersistenceStub();
        userPersistenceStub.insertUser(user);
        assertEquals(userPersistenceStub.findUser(username).getUserName(), user.getUserName());
    }

}
