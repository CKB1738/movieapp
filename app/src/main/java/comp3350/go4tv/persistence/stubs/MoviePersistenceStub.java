package comp3350.go4tv.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.MoviePersistence;

public class MoviePersistenceStub implements MoviePersistence {

    private List<Movie> movies;

    public MoviePersistenceStub(){
        movies = new ArrayList<>();
        movies.add(new Movie("Knock at the Cabin", "While vacationing at a remote cabin, a young girl and her two fathers are taken hostage by four armed strangers who demand that the family make an unthinkable choice to avert the apocalypse. With limited access to the outside world, the family must decide what they believe before all is lost.", 65));
        movies.add(new Movie( "Little Dixie", "Erstwhile Special Forces operative Doc Alexander is asked to broker a truce with the Mexican drug cartel in secrecy. When Oklahoma Governor Richard Jeffs celebrates the execution of a high-ranking cartel member on TV, his Chief of Staff and Doc inform him about the peace he just ended. But it's too late, as Cuco, the cartel's hatchet man, has set his vengeful sights on Doca's daughter Dixie", 62));
        movies.add(new Movie( "Plane", "After a heroic job of successfully landing his storm-damaged aircraft in a war zone, a fearless pilot finds himself between the agendas of multiple militias planning to take the plane and its passengers hostage.", 69));
        movies.add(new Movie( "Puss in Boots: The Last Wish", "Puss in Boots discovers that his passion for adventure has taken its toll: He has burned through eight of his nine lives, leaving him with only one life left. Puss sets out on an epic journey to find the mythical Last Wish and restore his nine lives.", 84));
        movies.add(new Movie( "Black Panther: Wakanda Forever", "Queen Ramonda, Shuri, Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King TChallas death.  As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross and forge a new path for the kingdom of Wakanda.", 74));
    }


    @Override
    public Movie getMovie(String name) {

        for(Movie m : movies){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Movie> getListOfMovie() {
        return movies;
    }
}
