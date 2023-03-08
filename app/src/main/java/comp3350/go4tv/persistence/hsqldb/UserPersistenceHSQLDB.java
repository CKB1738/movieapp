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
            final ResultSet rs = st.executeQuery("SELECT * FROM USER WHERE USERNAME = 'Xin'");
            while (rs.next()) {
                usr = rs.getString("USERNAME");
                pass = rs.getString("PASSWORD");
                if(usr.equals(username) && pass.equals(password)){
                    return true ;
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
        return null;
    }

    @Override
    public User updateUser(User user, String newUsername, String newPassword, String newEmail) {
        return null;
    }

    @Override
    public User getUserInfo(User user) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User findUser(String username) {
        return null;
    }
}
