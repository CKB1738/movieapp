package comp3350.go4tv.Persistance;

import org.junit.Before;

import comp3350.go4tv.objects.User;
import comp3350.go4tv.persistence.stubs.UserPersistenceStub;

public class UserPersistenceStubTest {

    private UserPersistenceStub userPersistenceStub = new UserPersistenceStub();

    @Before
    public void init(){
        User user1 = new User("Xin","umnie2@myumaniotba.ca","12345abc");
        User user2 = new User("Arsh","arsh@myumaniotba.ca","123456abc");
        User user3 = new User("kwame", "kwame@gmail.com", "kwame123");
        userPersistenceStub.insertUser()

    }
}
