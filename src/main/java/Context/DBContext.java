package Context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext{
//    
//    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
// /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
//    public Connection getConnection() throws Exception {
//        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
//        if (instance == null || instance.trim().isEmpty()) {
//            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
//        }
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection(url, userID, password);
//    }
//    private final String serverName = "jdbc:sqlserver://localhost:1433;";
//    private final String dbName = "ProjectSWP";
//    private final String portNumber = "1433";
//    private final String instance = "";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
//    private final String userID = "sa";
//    private final String password = "nhan203";
//    public static void main(String[] args) {
//        try {
//            System.out.println(new DBContext().getConnection());
//        } catch (Exception e) {
//        }
//    }public class DBContext {
    public Connection getConnection() throws Exception{
    String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=ProjectSWP;User=sa;Password=nhan203";
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection con = DriverManager.getConnection(connectionUrl);
    return con;
    }

}
