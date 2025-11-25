import java.sql.*;
import java.util.*;

public class BookDAO {

    public void add(String t, String a) throws Exception {
        Connection c = DB.get();
        PreparedStatement ps = c.prepareStatement("INSERT INTO books(title,author) VALUES(?,?)");
        ps.setString(1, t);
        ps.setString(2, a);
        ps.executeUpdate();
        c.close();
    }

    public List<String> list() throws Exception {
        List<String> r = new ArrayList<>();
        Connection c = DB.get();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM books");
        while (rs.next()) {
            r.add(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+(rs.getBoolean(4)?"Available":"Issued"));
        }
        c.close();
        return r;
    }

    public boolean remove(int id) throws Exception {
        Connection c = DB.get();
        PreparedStatement ps = c.prepareStatement("DELETE FROM books WHERE id=? AND available=true");
        ps.setInt(1, id);
        int k = ps.executeUpdate();
        c.close();
        return k > 0;
    }

    public List<String> search(String q) throws Exception {
        List<String> r = new ArrayList<>();
        Connection c = DB.get();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM books WHERE LOWER(title) LIKE LOWER(?)");
        ps.setString(1, "%"+q+"%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            r.add(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+(rs.getBoolean(4)?"Available":"Issued"));
        }
        c.close();
        return r;
    }
}
