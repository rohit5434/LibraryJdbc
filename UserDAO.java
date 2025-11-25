import java.sql.*;
import java.util.*;

public class UserDAO {

    public void add(String n) throws Exception {
        Connection c = DB.get();
        PreparedStatement ps = c.prepareStatement("INSERT INTO users(name) VALUES(?)");
        ps.setString(1, n);
        ps.executeUpdate();
        c.close();
    }

    public List<String> list() throws Exception {
        List<String> r = new ArrayList<>();
        Connection c = DB.get();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM users");
        while (rs.next()) {
            r.add(rs.getInt(1)+" | "+rs.getString(2));
        }
        c.close();
        return r;
    }
}
