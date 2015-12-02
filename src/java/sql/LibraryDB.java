/*
    (c) Ben Hay and Haris Cesko 2015
 */
package sql;

import edu.elon.user.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * A library database class that contains the insert, delete, and select 
 * functions needed to access the database
 */
public class LibraryDB {
    
    /**
     * adds a row to the database
     *
     * @param user
     * @return int
     */
    public static int insert(User user) {
        PreparedStatement ps = null;

        String query
                = "INSERT INTO User (firstname, lastname, email, booktitle, duedate, overdue) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            
            String dbURL = "jdbc:mysql://localhost:3307/library";
            String username = "adminHdBQxxH";
            String password = "84Mk8VbitbcK";
            
            String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            if((host != null) && (host.trim().length() > 1)){
                String port  = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
                String appname = System.getenv("OPENSHIFT_APP_NAME");
                username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                dbURL = "jdbc:mysql://" + host + ":" + port + "/" + appname;
            }
            
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmailAddress());
            ps.setString(4, user.getBookTitle());
            ps.setString(5, user.getDueDate());
            ps.setString(6, user.getOverdue());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            //pool.freeConnection(connection);
        }
    }

    /**
     * deletes a row from the database
     *
     * @param user
     * @return int
     */
    public static int delete(User user) {
        PreparedStatement ps = null;

        String query = "DELETE FROM User "
                + "WHERE Email = ?";
        try {
            
            String dbURL = "jdbc:mysql://localhost:3307/library";
            String username = "adminHdBQxxH";
            String password = "84Mk8VbitbcK";
            
            String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            if((host != null) && (host.trim().length() > 1)){
                String port  = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
                String appname = System.getenv("OPENSHIFT_APP_NAME");
                username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                dbURL = "jdbc:mysql://" + host + ":" + port + "/" + appname;
            }
            
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmailAddress());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            //pool.freeConnection(connection);
        }
    }

    /**
     * searches the database and returns all of the User objects in an ArrayList
     *
     * @return ArrayList<Users>;
     */
    public static ArrayList<User> selectUser() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM User";
        try {
            
            String dbURL = "jdbc:mysql://localhost:3307/library";
            String username = "adminHdBQxxH";
            String password = "84Mk8VbitbcK";
            
            String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            if((host != null) && (host.trim().length() > 1)){
                String port  = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
                String appname = System.getenv("OPENSHIFT_APP_NAME");
                username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                dbURL = "jdbc:mysql://" + host + ":" + port + "/" + appname;
            }
            
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()){
                User user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmailAddress(rs.getString("emailAddress"));
                user.setBookTitle(rs.getString("bookTitle"));
                user.setDueDate(rs.getString("dueDate"));
                user.setOverdue(rs.getString("overDue"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            //pool.freeConnection(connection);
        }
    }    
     
}
