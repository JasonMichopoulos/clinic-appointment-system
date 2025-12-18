import dbhelper.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello");
        System.out.println("Mak");

        try(Connection conn=DBHelper.getConnection()){
            System.out.println(conn!=null? "Done":"Fail");
        }catch (SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
}