/*
    (c) Ben Hay and Haris Cesko 2015
 */
package sql;

import edu.elon.user.User;
import java.sql.Connection;
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
                = "INSERT INTO library.user (firstName, lastName, emailAddress, bookTitle, dueDate, overDue) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection connection = cp.getConnection();
        
        try {
            
            String dbURL = "jdbc:mysql://localhost:3306/MySQLDS";
            String username = "root";
            String password = "mysqluser";
            
            String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            if((host != null) && (host.trim().length() > 1)){
                String port  = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
                String appname = System.getenv("OPENSHIFT_APP_NAME");
                username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                dbURL = "jdbc:mysql://" + host + ":" + port + "/" + appname;
            }     
            
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmailAddress());
            ps.setString(4, user.getBookTitle());
            ps.setString(5, user.getDueDate());
            ps.setString(6, user.getOverDue());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(connection);
        }
    }

    /**
     * deletes a row from the database based on id
     *
     * @param user
     * @return integer
     */
    public static int delete(String id) {
        PreparedStatement ps = null;

        String query
                = "delete from library.user where id = ?;";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection connection = cp.getConnection();
        
        try {
            
            String dbURL = "jdbc:mysql://localhost:3306";
            String username = "root";
            String password = "mysqluser";
            
            String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            if((host != null) && (host.trim().length() > 1)){
                String port  = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
                String appname = System.getenv("OPENSHIFT_APP_NAME");
                username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                dbURL = "jdbc:mysql://" + host + ":" + port + "/" + appname;
            }
            
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            //ps.setString(1, identity.toString());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(connection);
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
        
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection connection = cp.getConnection();
        
        String query = "SELECT * FROM User";
        
        try {
            
            String dbURL = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "mysqluser";
            
            String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            if((host != null) && (host.trim().length() > 1)){
                String port  = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
                String appname = System.getenv("OPENSHIFT_APP_NAME");
                username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                dbURL = "jdbc:mysql://" + host + ":" + port + "/" + appname;
            }
            
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
                user.setOverDue(rs.getString("overDue"));
                user.setId(rs.getString("id"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(connection);
        }
    }
    
}
