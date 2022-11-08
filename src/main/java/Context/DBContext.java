package Context;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DBContext {
    public Connection getConnection() throws Exception{
    String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Fast_Food;User=sa;Password=sa";
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection con = DriverManager.getConnection(connectionUrl);
    return con;
    }
}

