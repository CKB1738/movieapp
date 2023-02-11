package comp3350.go4tv.Persistence;

import static org.junit.Assert.*;
//import org.junit.Before;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import comp3350.go4tv.objects.User;
import comp3350.go4tv.persistence.stubs.UserPersistenceStub;

public class UserPersistenceTest {

        private UserPersistenceStub users = new UserPersistenceStub();


        @Before
        public void init(){
            User user1 = new User("Emil", "emil123@gmail.com", "emil12345");
            User user2 = new User("Craig", "craig@myumanitoba.ca", "123456789abc");

            users.insertUser(user1);
            users.insertUser(user2);
        }




    @Test
    public void verifyUserTest(){
        System.out.println("Starting verifyUserTest");


        String name = "Craig";
        String password = "123456789abc";
        String email = "craig@myumanitoba.ca";

        //User user = new User(name, email, password);
        //UserPersistenceStub userPersistenceStub = new UserPersistenceStub();
        //assertTrue(userPersistenceStub.verifyUser(user.getUserName(), user.getPassword()));
        assertTrue(users.verifyUser(name,password));

        System.out.println("Finished verifyUserTest");
    }


    @Test
    public void insertUserTest(){
        System.out.println("Starting insertUserTest");

        User user1 = new User("Emil", "emil123@gmail.com", "emil12345");
        User user2 = new User("Craig", "craig@myumanitoba.ca", "123456789abc");
        UserPersistenceStub userPersistenceStub1 = new UserPersistenceStub();
        assertNotNull(userPersistenceStub1.insertUser(user1));
        assertNull(userPersistenceStub1.insertUser(user2));

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
        assertNotNull(userPersistenceStub.updateUser(user,newUsername, newPassword, newEmail));
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
        UserPersistenceStub userPersistenceStub = new UserPersistenceStub();
        userPersistenceStub.insertUser(user);
        userPersistenceStub.deleteUser(user);
       // assertEquals("Deleting user", 5,);
    }
}
