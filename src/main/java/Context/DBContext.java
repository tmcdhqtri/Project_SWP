package Context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    public Connection getConnection() throws Exception{
    String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=ProjectSWP;User=sa;Password=nhan203";
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection con = DriverManager.getConnection(connectionUrl);
    return con;
    }
}