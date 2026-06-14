package dao;
import database.DBConnection;
import model.Notification;
import java.sql.*;
import java.util.*;

public class NotificationDAO {
    public boolean create(int userId,String title,String message){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("INSERT INTO notifications(user_id,title,message,is_read,created_at) VALUES(?,?,?,0,NOW())")){ ps.setInt(1,userId); ps.setString(2,title); ps.setString(3,message); return ps.executeUpdate()>0; }catch(Exception e){e.printStackTrace(); return false;} }
    public List<Notification> getByUser(int userId){ List<Notification> list=new ArrayList<>(); try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM notifications WHERE user_id=? ORDER BY id DESC")){ ps.setInt(1,userId); ResultSet rs=ps.executeQuery(); while(rs.next()) list.add(new Notification(rs.getInt("id"),rs.getInt("user_id"),rs.getString("title"),rs.getString("message"),rs.getBoolean("is_read"),rs.getString("created_at"))); }catch(Exception e){e.printStackTrace();} return list; }
    public boolean markRead(int id){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("UPDATE notifications SET is_read=1 WHERE id=?")){ ps.setInt(1,id); return ps.executeUpdate()>0; }catch(Exception e){e.printStackTrace(); return false;} }
}
