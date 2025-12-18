import databaseManager.DataBaseConnect;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello");
        System.out.println("Mak");

        System.out.println(DataBaseConnect.getConnection());
    }
}