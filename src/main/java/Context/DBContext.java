package Context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext{

    public static Connection getConnection()throws Exception {
        System.out.println("DBUtils begin");
        String connectionUrl = "jdbc:sqlserver://HIEUTRAN:1433;databaseName=Fast_Food;User=sa;Password=Changtrailaucaak";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(connectionUrl);
        return con;
     }
     
    public static void main(String[] args) throws Exception {
        System.out.println(DBContext.getConnection());
    }

}
