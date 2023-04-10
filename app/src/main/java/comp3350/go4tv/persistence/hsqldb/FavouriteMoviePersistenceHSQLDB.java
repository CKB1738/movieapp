package comp3350.go4tv.persistence.hsqldb;

import android.util.Log;

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
            String path = "";
            final PreparedStatement st = c.prepareStatement("SELECT * FROM MOVIE WHERE MOVIE.NAME = ?");
            st.setString(1,movieName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                name = rs.getString("NAME");
                description = rs.getString("DESCRIPTION");
                rating = rs.getInt("RATING");
                path = rs.getString("PATH");
                if(name.equals(movieName)){
                    currMovie = new Movie(name,description,rating);
//                    currMovie.setPath(path);
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
            String path = "";
            int rating;
            final PreparedStatement st = c.prepareStatement("SELECT * FROM FAVOURITEMOVIE JOIN MOVIE ON MOVIE.NAME = FAVOURITEMOVIE.MOVIENAME WHERE FAVOURITEMOVIE.USERNAME = ?");
            st.setString(1,username);
            ResultSet rs = st.executeQuery();
            //Log.d("!!!!!!!!!","!!!!!!");
            while (rs.next()) {
                name = rs.getString("NAME");
                description = rs.getString("DESCRIPTION");
                rating = rs.getInt("RATING");
                path = rs.getString("PATH");
                Movie currMovie = new Movie(name,description, rating);
//                currMovie.setPath(path);
//                Log.d("movieName",name);
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
        String path = "";
        try(final Connection c = connection()){

            final PreparedStatement st2 = c.prepareStatement("SELECT * FROM FAVOURITEMOVIE WHERE MOVIENAME = ? AND USERNAME = ?");
            st2.setString(1,movieName);
            st2.setString(2,userName);
            ResultSet rs2 = st2.executeQuery();

            if(!rs2.next()) {//this movie is in the list
                final PreparedStatement st1 = c.prepareStatement("SELECT * FROM MOVIE WHERE NAME = ?");//find the move
                st1.setString(1, movieName);
                final ResultSet rs1 = st1.executeQuery();
                while (rs1.next()) {
                    name = rs1.getString("NAME");
                    description = rs1.getString("DESCRIPTION");
                    rating = rs1.getInt("RATING");
                    path = rs1.getString("PATH");
                }
                newMovie = new Movie(name, description, rating);

                //insert new movie to favourite list
                final PreparedStatement st = c.prepareStatement("INSERT INTO FAVOURITEMOVIE VALUES(?,?)");
                st.setString(1, movieName);
                st.setString(2, userName);
                st.executeUpdate();
                return newMovie;
            }else{
                return null;
            }

        }catch(final SQLException e){
            throw new PersistenceException(e);

        }



    }





}
