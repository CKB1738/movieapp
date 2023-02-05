package comp3350.go4tv.business;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import comp3350.go4tv.application.Service;
import comp3350.go4tv.objects.User;
import comp3350.go4tv.persistence.UserPersistence;

public class AccessUser {

    private UserPersistence userPersistence = null;
    private User user;
    private List<User> users;

    public AccessUser(){
        userPersistence = Service.getUserPersistence();
        user = null;
        users = null;
    }

    public List<User> getUsers(){
        users = userPersistence.getUserList();

        return Collections.unmodifiableList(users);
    }
    public boolean verifyUser(String username, String password){
        userPersistence.verifyUser(username,password);
        return false;
    }

    public User insertUser(User user){
        return userPersistence.insertUser(user);
    }


    public void findUser(String userName){
        this.user = userPersistence.findUser(userName);
    }


    public User updateUser(String newUsername, String newPassword, String newEmail){

        return userPersistence.updateUser(this.user,newUsername, newPassword, newEmail);

    }

    public void deleteUser(){
        userPersistence.deleteUser(this.user);
    }

    public User getUserInfo(){
        return userPersistence.getUserInfo(this.user);
    }
}
