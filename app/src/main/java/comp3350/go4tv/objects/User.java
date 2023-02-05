package comp3350.go4tv.objects;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;
    private String email;
    private List<Comment> comments;

    private String password;

    public User(String userName, String email,String password){

        this.userName = userName;
        this.email = email;
        comments = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public boolean addComment(Comment comment){

        return this.comments.add(comment);
    }

    public String getPassword() {
        return password;
    }

    public boolean deleteComment(Comment comment){
        return this.comments.remove(comment);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean equals(User user) {
        return this.getUserName().equals(user.getUserName());
    }
}
