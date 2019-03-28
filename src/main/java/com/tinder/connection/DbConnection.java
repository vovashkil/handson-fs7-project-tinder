package com.tinder.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private String path = "jdbc:postgresql://tinderdb.cmzzf2pfpgom.eu-central-1.rds.amazonaws.com:5432/tinderdb";
    private String username = "tinder";
    private String password = "Tinder!234";

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
