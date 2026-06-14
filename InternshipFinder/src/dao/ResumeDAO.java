package dao;
import database.DBConnection;
import model.Resume;
import java.sql.*;
import java.util.*;

public class ResumeDAO {
    public boolean create(Resume r){
        String sql="INSERT INTO resumes(student_id,title,resume_path,cover_letter_path,student_id_path,created_at) VALUES(?,?,?,?,?,NOW())";
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,r.getStudentId()); ps.setString(2,r.getTitle()); ps.setString(3,r.getResumePath()); ps.setString(4,r.getCoverLetterPath()); ps.setString(5,r.getStudentIdPath()); return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace(); return false;}
    }
    public Resume getLatestByStudent(int sid){
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM resumes WHERE student_id=? ORDER BY id DESC LIMIT 1")){
            ps.setInt(1,sid); ResultSet rs=ps.executeQuery(); if(rs.next()) return map(rs);
        }catch(Exception e){e.printStackTrace();} return null;
    }
    public java.util.List<Resume> getByStudent(int sid){ List<Resume> list=new ArrayList<>(); try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM resumes WHERE student_id=? ORDER BY id DESC")){ ps.setInt(1,sid); ResultSet rs=ps.executeQuery(); while(rs.next()) list.add(map(rs)); }catch(Exception e){e.printStackTrace();} return list; }
    private Resume map(ResultSet rs)throws SQLException{ return new Resume(rs.getInt("id"),rs.getInt("student_id"),rs.getString("title"),rs.getString("resume_path"),rs.getString("cover_letter_path"),rs.getString("student_id_path"),rs.getString("created_at")); }
}
