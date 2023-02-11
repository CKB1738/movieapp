package comp3350.go4tv.application;

import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.go4tv.persistence.UserPersistence;

public class ServiceTest {

    @Test
    public void testService(){
        System.out.println("\nStart testing Service");

        UserPersistence testPersistence = Service.getUserPersistence();
        assertNotNull(testPersistence);

        System.out.println("End testing Service");
    }
}
