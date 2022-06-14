package sm.supermarket;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Database Connection
 */
public class DBConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "supermarket";
        String databaseUser = "root";
        String databasePassword = "kujtim11324";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }

}
