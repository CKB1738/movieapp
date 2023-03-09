package comp3350.go4tv.Persistence;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import comp3350.go4tv.application.Main;
import comp3350.go4tv.persistence.hsqldb.UserPersistenceHSQLDB;

public class UserPersistenceHSQLDBTest {

    @Test
    public void verifyUserTest(){
        System.out.println("Starting test verifyUser - HSQLDB");
        System.out.println(Main.getDBPathName());
        UserPersistenceHSQLDB userPersistenceHSQLDB = new UserPersistenceHSQLDB("db");
        assertTrue(userPersistenceHSQLDB.verifyUser("Craig","123456789abc"));
    }

}
