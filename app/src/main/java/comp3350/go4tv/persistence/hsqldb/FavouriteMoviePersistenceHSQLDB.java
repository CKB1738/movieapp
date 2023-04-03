package comp3350.go4tv.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.go4tv.objects.Movie;
import comp3350.go4tv.persistence.FavouriteMoviePersistence;

public class FavouriteMoviePersistenceHSQLDB implements FavouriteMoviePersistence {
    private final String dbPath;


    public FavouriteMoviePersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    @Override
    public Movie getMovie(String movieName) {
        try (final Connection c = connection()) {
            String name = "";
            String description = "";
            int rating;
            Movie currMovie = null;
            final PreparedStatement st = c.prepareStatement("SELECT * FROM MOVIE WHERE MOVIE.NAME = ?");
            st.setString(1,movieName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                name = rs.getString("MOVIENAME");
                description = rs.getString("DESCRIPTION");
                rating = rs.getInt("RATING");

                if(name.equals(movieName)){
                    currMovie = new Movie(name,description,rating);
                }
            }
            return currMovie;

        } catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Movie> getListOfMovie(String username) {

        List<Movie> movieList = new ArrayList<>();

        try (final Connection c = connection()) {
            String name = "";//movie name
            String description = "";
            int rating;
            final PreparedStatement st = c.prepareStatement("SELECT * FROM USER JOIN FAVOURITEMOVIE ON USER.USERNAME = FAVOURITEMOVIE.USERNAME JOIN MOVIE ON MOVIE.NAME = FAVOURITEMOVIE.MOVIENAME WHERE USER.USERNAME = ?");
            st.setString(1,username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                name = rs.getString("NAME");
                description = rs.getString("DESCRIPTION");
                rating = rs.getInt("RATING");
                Movie currMovie = new Movie(name,description, rating);

                movieList.add(currMovie);
            }

        } catch (final SQLException e){
            throw new PersistenceException(e);
        }

        return movieList;
    }

    @Override
    public Movie addToList(String userName, String movieName){
        String name = "";
        String description = "";
        int rating = -1;
        Movie newMovie = null;
        try(final Connection c = connection()){
            final PreparedStatement st1 = c.prepareStatement("SELECT * FROM MOVIE WHERE NAME = ?");//find the move
            st1.setString(1,movieName);
            final ResultSet rs1 = st1.executeQuery();
            while(rs1.next()){
                name = rs1.getString("NAME");
                description = rs1.getString("DESCRIPTION");
                rating = rs1.getInt("RATING");
            }

            if(name.equals("")){
                //movie not in databse
                return null;
            }else {
                newMovie = new Movie(name, description, rating);

                //insert new movie to favourite list
                final PreparedStatement st = c.prepareStatement("INSERT INTO FAVOURITEMOVIE VALUES(?,?)");
                st.setString(1, name);
                st.setString(2, userName);
                return newMovie;
            }

        }catch(final SQLException e){
            throw new PersistenceException(e);

        }



    }





}
