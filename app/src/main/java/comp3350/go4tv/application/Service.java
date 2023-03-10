package comp3350.go4tv.application;

import android.util.Log;

import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.MoviePersistence;
import comp3350.go4tv.persistence.UserPersistence;
import comp3350.go4tv.persistence.hsqldb.MoviePersistenceHSQLDB;
import comp3350.go4tv.persistence.hsqldb.UserPersistenceHSQLDB;
import comp3350.go4tv.persistence.stubs.MoviePersistenceStub;
import comp3350.go4tv.persistence.stubs.UserPersistenceStub;

public class Service {

    private static UserPersistence userPersistence = null;
    private static MoviePersistence moviePersistence = null;

    public static synchronized UserPersistence getUserPersistence(){
        if(userPersistence == null){
            userPersistence = new UserPersistenceHSQLDB(Main.getDBPathName());
        }

        return userPersistence;
    }

    public static synchronized MoviePersistence getMoviePersistence(){
        if(moviePersistence == null){
            moviePersistence = new MoviePersistenceHSQLDB(Main.getDBPathName());
        }

        return moviePersistence;
    }

}
