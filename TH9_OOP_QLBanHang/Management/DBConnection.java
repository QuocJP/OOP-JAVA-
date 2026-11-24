package Management;

import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBANHANG;encrypt=true;trustServerCertificate=true;";
    private static final String user = "sa";
    private static final String password = "quoc";
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}