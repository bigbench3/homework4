/*
    (c) Ben Hay and Haris Cesko
 */
package sql;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * a connection pool class 
 */
public class ConnectionPool {
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/MySQLDS");
        } catch (NamingException e) {
            System.out.println(e);
        }
    }
          
    /**
     * gets an instance of the connection pool
     *
     * @return ConnectionPool
     */
    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }
    
    /**
     * gets the connection
     *
     * @return Connection
     */
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    /**
     * sets the connection as free and closes it out
     *
     * @param c
     */
    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}