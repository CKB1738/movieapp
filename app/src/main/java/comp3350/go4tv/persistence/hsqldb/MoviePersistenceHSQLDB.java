package comp3350.go4tv.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.objects.User;
import comp3350.go4tv.persistence.MoviePersistence;

public class MoviePersistenceHSQLDB implements MoviePersistence {
    private final String dbPath;


    public MoviePersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    @Override
    public Movie getMovie(String movieId){
        try (final Connection c = connection()) {
            String id = "";
            String name = "";
            String description = "";
            int rating;
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM MOVIE");
            while (rs.next()) {
                id = rs.getString("MOVIEID");
                name = rs.getString("NAME");
                description = rs.getString("DESCRIPTION");
                rating = rs.getInt("RATING");

                if(id.equals(movieId)){
                    Movie currMovie = new Movie(id,name,description, rating);
                    return currMovie;
                }
            }

        } catch (final SQLException e){
            throw new PersistenceException(e);
        }
        return null;
    }

    @Override
    public List<Movie> getListOfMovie() {
        List<Movie> movieList = new ArrayList<>();

        try (final Connection c = connection()) {
            String id = "";
            String name = "";
            String description = "";
            int rating;
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM MOVIE");
            while (rs.next()) {
                id = rs.getString("MOVIEID");
                name = rs.getString("NAME");
                description = rs.getString("DESCRIPTION");
                rating = rs.getInt("RATING");
                Movie currMovie = new Movie(id,name,description, rating);

                movieList.add(currMovie);
            }

        } catch (final SQLException e){
            throw new PersistenceException(e);
        }

        return movieList;
    }
}
