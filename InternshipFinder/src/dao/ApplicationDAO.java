package dao;
import database.DBConnection;
import model.Application;
import util.Constants;
import java.sql.*;
import java.util.*;

public class ApplicationDAO {
    public boolean apply(Application a){
        if(hasApplied(a.getJobId(),a.getStudentId())) return false;
        String sql="INSERT INTO applications(job_id,student_id,resume_id,status,cover_note,applied_at) VALUES(?,?,?,?,?,NOW())";
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,a.getJobId()); ps.setInt(2,a.getStudentId()); ps.setInt(3,a.getResumeId()); ps.setString(4,Constants.APP_APPLIED); ps.setString(5,a.getCoverNote()); return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace(); return false;}
    }
    public boolean hasApplied(int jobId,int studentId){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT id FROM applications WHERE job_id=? AND student_id=?")){ ps.setInt(1,jobId); ps.setInt(2,studentId); return ps.executeQuery().next(); }catch(Exception e){e.printStackTrace(); return true;} }
    public List<Application> getByStudent(int sid){ return getBySql("SELECT * FROM applications WHERE student_id="+sid+" ORDER BY id DESC"); }
    public List<Application> getByJob(int jobId){ return getBySql("SELECT * FROM applications WHERE job_id="+jobId+" ORDER BY id DESC"); }
    public List<Application> getAll(){ return getBySql("SELECT * FROM applications ORDER BY id DESC"); }
    public boolean updateStatus(int appId,String status){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("UPDATE applications SET status=? WHERE id=?")){ ps.setString(1,status); ps.setInt(2,appId); return ps.executeUpdate()>0; }catch(Exception e){e.printStackTrace(); return false;} }
    private List<Application> getBySql(String sql){ List<Application> list=new ArrayList<>(); try(Connection con=DBConnection.getConnection(); Statement st=con.createStatement(); ResultSet rs=st.executeQuery(sql)){ while(rs.next()) list.add(map(rs)); }catch(Exception e){e.printStackTrace();} return list; }
    private Application map(ResultSet rs)throws SQLException{ return new Application(rs.getInt("id"),rs.getInt("job_id"),rs.getInt("student_id"),rs.getInt("resume_id"),rs.getString("status"),rs.getString("cover_note"),rs.getString("applied_at")); }
}
