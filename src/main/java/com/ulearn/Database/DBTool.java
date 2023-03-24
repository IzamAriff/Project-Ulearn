package com.ulearn.Database;

import java.sql.*;

public class DBTool {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/project_ulearn";
    private static final String DB_USER = "projekt_ulearn";
    private static final String DB_PASSWORD = "ulearn123";
    private Connection conn;

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

    public void connect() {
        // change string to attribute
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        catch(Exception e){ System.out.println(e);}

    }

    public void runQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Student");
            while (rs.next())
                System.out.println(rs.getString(1));
        }
        catch(Exception e){ System.out.println(e);}

    }

    public void close() {
        try {
            conn.close();
        }
        catch(Exception e){ System.out.println(e);}
    }

    //use this to get connection to database in other class: Connection conn = DBTool.getConnection();
}
