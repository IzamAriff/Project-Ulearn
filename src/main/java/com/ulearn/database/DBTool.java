package com.ulearn.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTool {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/project_ulearn";
    private static final String DB_USER = "projekt_ulearn";
    private static final String DB_PASSWORD = "ulearn123";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Driver not found.");
        }
        return conn;
    }

    //use this to get connection to database in other class: Connection conn = DBTool.getConnection();
}
