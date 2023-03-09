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

import comp3350.go4tv.objects.User;
import comp3350.go4tv.persistence.UserPersistence;

public class UserPersistenceHSQLDB implements UserPersistence {

    private final String dbPath;


    public UserPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");

    }





    @Override
    public boolean verifyUser(String username, String password) {
        String usr = "";
        String pass = "";
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM USER");
            while (rs.next()) {
                usr = rs.getString("USERNAME");
                pass = rs.getString("PASSWORD");
                if(usr.equals(username) && pass.equals(password)){
                    return true;
                }
            }
            rs.close();
            st.close();

            return false;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }

    @Override
    public User insertUser(User user) {

        String username = user.getUserName();
        String passWord = user.getPassword();
        String email = user.getEmail();

        try (final Connection c = connection()) {
            String usr = "";
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM USER");
            while (rs.next()) {
                usr = rs.getString("USERNAME");
                if(usr.equals(username)){
                    return null;
                }
            }

            final PreparedStatement ps = c.prepareStatement("INSERT INTO USER VALUES(?,?,?)");
            ps.setString(1,username);
            ps.setString(2,passWord);
            ps.setString(3,email);
            ps.executeUpdate();
            rs.close();
            st.close();
            return user;


        } catch (final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public User updateUser(String oldUsername, String newUsername, String newPassword, String newEmail) {


        try (final Connection c = connection()) {

            if(findUser(oldUsername) != null) {
                final PreparedStatement pr = c.prepareStatement("UPDATE USER SET USERNAME = ?, PASSWORD = ?, EMAIL = ? WHERE USERNAME = ?");
                pr.setString(1, newUsername);
                pr.setString(2, newPassword);
                pr.setString(3, newEmail);
                pr.setString(4, oldUsername);
                return new User(newUsername,newPassword,newEmail);
            }
        } catch (final SQLException e){
            throw new PersistenceException(e);
        }
        return null;
    }

    @Override
    public User getUserInfo(User user) {

        String username = user.getUserName();
        if(findUser(username) != null){
            return user;
        }else{
            return null;
        }

    }

    @Override
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        try (final Connection c = connection()) {
            String usr = "";
            String pass = "";
            String email = "";
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM USER");
            while (rs.next()) {
                usr = rs.getString("USERNAME");
                pass = rs.getString("PASSWORD");
                email = rs.getString("EMAIL");
                User currUser = new User(usr,pass,email);

                userList.add(currUser);

            }

        } catch (final SQLException e){
            throw new PersistenceException(e);
        }



        return userList;
    }

    @Override
    public void deleteUser(User user) {
        String username = user.getUserName();
        if(findUser(username) != null){
            try (final Connection c = connection()) {
                final PreparedStatement sc = c.prepareStatement("DELETE FROM USER WHERE USERNAME = ?");
                sc.setString(1, username);
                sc.executeUpdate();
            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
        }
    }

    @Override
    public User findUser(String username) {

        try (final Connection c = connection()) {
            String usr = "";
            String pass = "";
            String email = "";
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM USER");
            while (rs.next()) {
                usr = rs.getString("USERNAME");
                pass = rs.getString("PASSWORD");
                email = rs.getString("EMAIL");

                if(usr.equals(username)){
                    User currUser = new User(usr,pass,email);
                    return currUser;
                }
            }

        } catch (final SQLException e){
            throw new PersistenceException(e);
        }
        return null;
    }
}
