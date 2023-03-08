package comp3350.go4tv.application;

import comp3350.go4tv.persistence.UserPersistence;
import comp3350.go4tv.persistence.hsqldb.UserPersistenceHSQLDB;
import comp3350.go4tv.persistence.stubs.UserPersistenceStub;

public class Service {

    private static UserPersistence userPersistence = null;


    public static synchronized UserPersistence getUserPersistence(){
        if(userPersistence == null){
//            userPersistence = new UserPersistenceStub();
            userPersistence = new UserPersistenceHSQLDB(Main.getDBPathName());
        }

        return userPersistence;
    }
}
