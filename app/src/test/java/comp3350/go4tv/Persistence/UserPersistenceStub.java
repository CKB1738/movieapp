package comp3350.go4tv.Persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.go4tv.objects.User;
import comp3350.go4tv.persistence.UserPersistence;

public class UserPersistenceStub implements UserPersistence {

    private List<User> users;

    public UserPersistenceStub(){
        users = new ArrayList<>();
        users.add(new User("Xin","umnie2@myumaniotba.ca","12345abc"));
        users.add(new User("Arsh","arsh@myumaniotba.ca","123456abc"));
        users.add(new User("Het","het@myumaniotba.ca","1234567abc"));
        users.add(new User("Owl","owl@myumaniotba.ca","12345678abc"));
        users.add(new User("Craig","craig@myumanitoba.ca","123456789abc"));
    }
    public boolean verifyUser(String username, String password){

        for(User user : users){
            if(user.getUserName().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public User insertUser(User user){
        String username = user.getUserName();

        for(User u : users){
            if(u.getUserName().equals(username)){
                return null;
            }
        }
        users.add(user);
        return user;
    }

    public User updateUser(String oldUsername, String newPassword, String newEmail){

        for(User u : users){
            if(u.getUserName().equals(oldUsername)){//find user

                if (!u.getPassword().equals(newPassword)){
                    u.setPassword(newPassword);
                }
                if(!u.getEmail().equals(newEmail)){
                    u.setEmail(newEmail);
                }
                User currUser = findUser(oldUsername);
                return  currUser;
            }

        }

        return null;
    }

    public User getUserInfo(User user){
        for(User u : users){
            if(u.equals(user))
                return u;
        }
        return null;
    }


    public List<User> getUserList(){
        return users;
    }
    public void deleteUser(User user){
        for(User u : users){
            if(u.equals(user))
                users.remove(u);
        }
    }

    public User findUser(String username){
        for(User u : users){
            if(u.getUserName().equals(username))
                return u;
        }
        return null;
    }
}
