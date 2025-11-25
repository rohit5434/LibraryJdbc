import java.sql.*;

public class DB {
    private static final String url = "jdbc:postgresql://localhost:5433/librarydb";
    private static final String user = "postgres";
    private static final String pass = "password";

    public static Connection get() throws Exception {
        return DriverManager.getConnection(url, user, pass);
    }
}
