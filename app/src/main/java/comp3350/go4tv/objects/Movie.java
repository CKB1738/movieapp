package comp3350.go4tv.objects;


public class Movie {

    private final String id;
    private final String name;
    private final String description;
    private final int rating;


    public Movie(String id, String name, String description, int rating){
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public String getId(){return id;}
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }
}
