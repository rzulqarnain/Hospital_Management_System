package database;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDataSource;


public class ConnectionManager {

    private static ClientDataSource ds = null;
    private static final String server = "localhost";
    private static final int port = 1527;
    private static final String dbname = "Hospital";
    private static final String username = "app";
    private static final String password = "app";

    private ConnectionManager() {
    } 
    public static Connection getConnection() throws SQLException {
        initDataSource();
        Connection conn = ds.getConnection();
        return conn;
    }

    public static boolean testConnection() {
        boolean res;

        try {
            Connection conn = getConnection();
            res = conn != null;
        } catch (SQLException ex) {
            res = false;
        }

        return res;
    }

    private static void initDataSource() {
        if (isNewSource()) {
            ds = new ClientDataSource();
            ds.setServerName(server);
            ds.setPortNumber(port);
            ds.setDatabaseName(dbname);
            ds.setUser(username);
            ds.setPassword(password);
        }
    }

    private static boolean isNewSource() {
        return (ds == null)
                || (!server.equals(ds.getServerName()))
                || (port != ds.getPortNumber())
                || (!dbname.equals(ds.getDatabaseName()))
                || (!username.equals(ds.getUser()))
                || (!password.equals(ds.getPassword()));
    }

}
