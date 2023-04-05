package comp3350.go4tv.objects;



import android.media.Image;
import android.widget.ImageView;

import comp3350.go4tv.R;

public class Movie {

    private final String name;
    private final String description;
    private final int rating;

    private String path;
    private ImageView image;
    public Movie(String name, String description, int rating){
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
    public int getImage(){
        String name = this.name;
        switch (name){
            case "Plane":
                return R.drawable.plane;
            case "Knock at the Cabin":
                return R.drawable.knock_at_the_cabin;
            case "Puss in Boots: The Last Wish":
                return R.drawable.puss_in_boots;
            case "Black Panther: Wakanda Forever":
                return R.drawable.black_panther;
            case "Little Dixie":
                return R.drawable.little_dixie;
        }
        return -1;
    }
}
