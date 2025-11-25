import java.sql.*;

public class IssueDAO {

    public boolean issue(int bid, int uid) throws Exception {
        Connection c = DB.get();
        ResultSet rs = c.createStatement().executeQuery("SELECT available FROM books WHERE id=" + bid);
        if (!rs.next() || !rs.getBoolean(1)) {
            c.close();
            return false;
        }
        c.setAutoCommit(false);
        PreparedStatement ps1 = c.prepareStatement("UPDATE books SET available=false WHERE id=?");
        ps1.setInt(1, bid);
        ps1.executeUpdate();
        PreparedStatement ps2 = c.prepareStatement("INSERT INTO issued(book_id,user_id) VALUES(?,?)");
        ps2.setInt(1, bid);
        ps2.setInt(2, uid);
        ps2.executeUpdate();
        c.commit();
        c.close();
        return true;
    }

    public boolean ret(int bid) throws Exception {
        Connection c = DB.get();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM issued WHERE book_id=" + bid);
        if (!rs.next()) {
            c.close();
            return false;
        }
        c.setAutoCommit(false);
        PreparedStatement ps1 = c.prepareStatement("UPDATE books SET available=true WHERE id=?");
        ps1.setInt(1, bid);
        ps1.executeUpdate();
        PreparedStatement ps2 = c.prepareStatement("DELETE FROM issued WHERE book_id=?");
        ps2.setInt(1, bid);
        ps2.executeUpdate();
        c.commit();
        c.close();
        return true;
    }
}
