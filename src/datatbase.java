package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class datatbase {

    private static Connection connection;

    public static Connection getConnection() {
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","mithun","ms06");
          
        }
        catch(Exception ex){
            System.out.println("  "+ex);
        }
        return connection;
    }
}