package dao;
import database.DBConnection;
import model.Report;
import java.sql.*;
import java.util.*;
public class ReportDAO {
    public boolean add(int userId,int jobId,String reason){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("INSERT INTO reports(user_id,job_id,reason,status,created_at) VALUES(?,?,?,'OPEN',NOW())")){ ps.setInt(1,userId); ps.setInt(2,jobId); ps.setString(3,reason); return ps.executeUpdate()>0; }catch(Exception e){e.printStackTrace(); return false;} }
    public List<Report> getAll(){ List<Report> list=new ArrayList<>(); try(Connection con=DBConnection.getConnection(); Statement st=con.createStatement(); ResultSet rs=st.executeQuery("SELECT * FROM reports ORDER BY id DESC")){ while(rs.next()) list.add(new Report(rs.getInt("id"),rs.getInt("user_id"),rs.getInt("job_id"),rs.getString("reason"),rs.getString("status"),rs.getString("created_at"))); }catch(Exception e){e.printStackTrace();} return list; }
    public boolean close(int id){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("UPDATE reports SET status='CLOSED' WHERE id=?")){ ps.setInt(1,id); return ps.executeUpdate()>0; }catch(Exception e){e.printStackTrace();return false;} }
}
