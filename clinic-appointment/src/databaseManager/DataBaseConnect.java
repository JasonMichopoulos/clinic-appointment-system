package databaseManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnect {

    private static final String dbURL = "jdbc:sqlite:resources/clinic.db";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(dbURL);
        } catch (Exception e){
            throw new RuntimeException("Cannot connect to database", e);
        }
    }

}
