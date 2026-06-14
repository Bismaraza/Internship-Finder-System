package dao;
import database.DBConnection;
import model.Bookmark;
import java.sql.*;
import java.util.*;

public class BookmarkDAO {
    public boolean add(int studentId,int jobId){
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("INSERT IGNORE INTO bookmarks(student_id,job_id,created_at) VALUES(?,?,NOW())")){
            ps.setInt(1,studentId); ps.setInt(2,jobId); return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace(); return false;}
    }
    public boolean remove(int id){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("DELETE FROM bookmarks WHERE id=?")){ ps.setInt(1,id); return ps.executeUpdate()>0; }catch(Exception e){e.printStackTrace(); return false;} }
    public List<Bookmark> getByStudent(int sid){ List<Bookmark> list=new ArrayList<>(); try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM bookmarks WHERE student_id=? ORDER BY id DESC")){ ps.setInt(1,sid); ResultSet rs=ps.executeQuery(); while(rs.next()) list.add(new Bookmark(rs.getInt("id"),rs.getInt("student_id"),rs.getInt("job_id"),rs.getString("created_at"))); }catch(Exception e){e.printStackTrace();} return list; }
}
