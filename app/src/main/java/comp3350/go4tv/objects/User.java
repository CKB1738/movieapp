package comp3350.go4tv.objects;


import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import comp3350.go4tv.R;

public class User {

    private String userName;
    private String email;
    private final List<Comment> comments;

    private String password;

    public User(String userName, String email,String password){

        this.userName = userName;
        this.email = email;
        this.password = password;
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

    public Comment addComment(Comment comment){
        this.comments.add(comment);
        return comment;
    }
    public boolean deleteComment(Comment comment){
        return this.comments.remove(comment);
    }


    public String getPassword() {
        return password;
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
