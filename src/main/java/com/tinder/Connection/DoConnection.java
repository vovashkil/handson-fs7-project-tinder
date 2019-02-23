package main.java.com.tinder.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DoConnection {

    private String path = "jdbc:postgresql://localhost:5432/danit";
    private String username = "danit";
    private String password = "danit";

    private Connection connection = null;

    private Connection connect() throws SQLException {

        return DriverManager.getConnection(path, username, password);

    }

    public Connection connection() {

        if (connection == null) {
            try {
                connection = connect();
            } catch (SQLException e) {
                throw new IllegalStateException("Something went wrong.");
            }
        }

        return this.connection;

    }

}
