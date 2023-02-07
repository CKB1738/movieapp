package comp3350.go4tv.objects;

import java.util.List;

public class Movie {
    private final String name;

    private final String people;

    private final String overview;

    private final int year;

    private final String genre;

    public Movie(String name, String people, String overview, int year, String genre){
        this.name = name;
        this.genre = genre;
        this.overview = overview;
        this.year = year;
        this.people = people;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public String getPeople() {
        return people;
    }


}
