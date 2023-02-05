package comp3350.go4tv.persistence;

import java.util.List;

import comp3350.go4tv.objects.User;

public interface UserPersistence {

    boolean verifyUser(String username, String password);

    User insertUser(User user);

    User updateUser(User user, String newUsername, String newPassword, String newEmail);

    User getUserInfo(User user);

    List<User> getUserList();
    void deleteUser(User user);

    User findUser(String username);
}
