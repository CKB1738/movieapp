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
    public Movie getMovie(String movieName){
        try (final Connection c = connection()) {
            String id = "";
            String name = "";
            String description = "";
            String path ="";
            int rating;
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM MOVIE");
            while (rs.next()) {
                name = rs.getString("NAME");
                description = rs.getString("DESCRIPTION");
                rating = rs.getInt("RATING");
                path = rs.getString("PATH");
                if(id.equals(movieName)){
                    Movie currMovie = new Movie(name,description, rating);
//                    currMovie.setPath(path);
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
            String path ="";
            int rating;
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM MOVIE");
            while (rs.next()) {
                name = rs.getString("NAME");
                description = rs.getString("DESCRIPTION");
                rating = rs.getInt("RATING");
                path = rs.getString("PATH");
                Movie currMovie = new Movie(name,description, rating);

//                currMovie.setPath(path);
                movieList.add(currMovie);
            }

        } catch (final SQLException e){
            throw new PersistenceException(e);
        }

        return movieList;
    }
}
