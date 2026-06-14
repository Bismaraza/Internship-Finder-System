package dao;
import database.DBConnection;
import model.Student;
import java.sql.*;

public class StudentDAO {
    public boolean createDefault(int userId, String name) {
        String sql="INSERT INTO students(user_id,full_name,education,skills,field_of_study,city,availability,phone) VALUES(?,?,?,?,?,?,?,?)";
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,userId); ps.setString(2,name); ps.setString(3,""); ps.setString(4,""); ps.setString(5,""); ps.setString(6,""); ps.setString(7,""); ps.setString(8,"");
            return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace(); return false;}
    }
    public Student getByUserId(int userId){
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM students WHERE user_id=?")){
            ps.setInt(1,userId); ResultSet rs=ps.executeQuery(); if(rs.next()) return map(rs);
        }catch(Exception e){e.printStackTrace();} return null;
    }
    public Student getById(int id){
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM students WHERE id=?")){
            ps.setInt(1,id); ResultSet rs=ps.executeQuery(); if(rs.next()) return map(rs);
        }catch(Exception e){e.printStackTrace();} return null;
    }
    public boolean update(Student s){
        String sql="UPDATE students SET full_name=?, education=?, skills=?, field_of_study=?, city=?, availability=?, phone=? WHERE user_id=?";
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,s.getFullName()); ps.setString(2,s.getEducation()); ps.setString(3,s.getSkills()); ps.setString(4,s.getFieldOfStudy()); ps.setString(5,s.getCity()); ps.setString(6,s.getAvailability()); ps.setString(7,s.getPhone()); ps.setInt(8,s.getUserId());
            return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace(); return false;}
    }
    private Student map(ResultSet rs) throws SQLException{
        return new Student(rs.getInt("id"),rs.getInt("user_id"),rs.getString("full_name"),rs.getString("education"),rs.getString("skills"),rs.getString("field_of_study"),rs.getString("city"),rs.getString("availability"),rs.getString("phone"));
    }
}
