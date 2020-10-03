package com.codeintelx.bank.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/OnlineBankManagementSystem?serverTimezone=UTC";
    private String username = "root";
    private String password = "Codeintelx";
    //key to singleton (private) cant instantiate the class externally (Cant call constructor), but can internally.
    private DatabaseConnection() throws SQLException {
       // try {
            //Class.forName("org.mysql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        //} catch (ClassNotFoundException ex) {
            //System.out.println("Something is wrong with the DB connection String : " + ex.getMessage());
        //}
    }

    public Connection getConnection() {
        return connection;
    }
    //ensures 1 connection instance
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
