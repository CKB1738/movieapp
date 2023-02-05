package comp3350.go4tv.objects;

import java.time.LocalDateTime;

public class Comment {

    private String comment;
    private Movie movie;
    private User user;
    private LocalDateTime time;

    public Comment(String comment, Movie movie, User user, LocalDateTime time){
        this.comment = comment;
        this.movie = movie;
        this.time = time;
        this.user = user;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public User getUser() {
        return user;
    }
}
