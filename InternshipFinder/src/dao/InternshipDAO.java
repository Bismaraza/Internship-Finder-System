package dao;
import database.DBConnection;
import model.Internship;
import util.Constants;
import java.sql.*;
import java.util.*;

public class InternshipDAO {
    public boolean create(Internship j){
        String sql="INSERT INTO internships(company_id,title,field,city,type,duration,stipend,requirements,description,deadline,status,created_at) VALUES(?,?,?,?,?,?,?,?,?,?,?,NOW())";
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,j.getCompanyId()); ps.setString(2,j.getTitle()); ps.setString(3,j.getField()); ps.setString(4,j.getCity()); ps.setString(5,j.getType()); ps.setString(6,j.getDuration()); ps.setDouble(7,j.getStipend()); ps.setString(8,j.getRequirements()); ps.setString(9,j.getDescription()); ps.setString(10,j.getDeadline()); ps.setString(11,j.getStatus()==null?Constants.JOB_PENDING:j.getStatus());
            return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace(); return false;}
    }
    public List<Internship> search(String field,String city,String type,String duration){
        List<Internship> list=new ArrayList<>(); String sql="SELECT * FROM internships WHERE status='APPROVED' AND (?='' OR field LIKE ?) AND (?='' OR city LIKE ?) AND (?='' OR type=?) AND (?='' OR duration LIKE ?) ORDER BY id DESC";
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,field); ps.setString(2,"%"+field+"%"); ps.setString(3,city); ps.setString(4,"%"+city+"%"); ps.setString(5,type); ps.setString(6,type); ps.setString(7,duration); ps.setString(8,"%"+duration+"%");
            ResultSet rs=ps.executeQuery(); while(rs.next()) list.add(map(rs));
        }catch(Exception e){e.printStackTrace();} return list;
    }
    public List<Internship> getAll(){ return getBySql("SELECT * FROM internships ORDER BY id DESC"); }
    public List<Internship> getPending(){ return getBySql("SELECT * FROM internships WHERE status='PENDING' ORDER BY id DESC"); }
    public List<Internship> getByCompany(int companyId){ return getBySql("SELECT * FROM internships WHERE company_id="+companyId+" ORDER BY id DESC"); }
    public Internship getById(int id){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM internships WHERE id=?")){ ps.setInt(1,id); ResultSet rs=ps.executeQuery(); if(rs.next()) return map(rs); }catch(Exception e){e.printStackTrace();} return null; }
    public boolean updateStatus(int id,String status){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("UPDATE internships SET status=? WHERE id=?")){ ps.setString(1,status); ps.setInt(2,id); return ps.executeUpdate()>0; }catch(Exception e){e.printStackTrace(); return false;} }
    public boolean delete(int id){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("DELETE FROM internships WHERE id=?")){ ps.setInt(1,id); return ps.executeUpdate()>0; }catch(Exception e){e.printStackTrace(); return false;} }
    private List<Internship> getBySql(String sql){ List<Internship> list=new ArrayList<>(); try(Connection con=DBConnection.getConnection(); Statement st=con.createStatement(); ResultSet rs=st.executeQuery(sql)){ while(rs.next()) list.add(map(rs)); }catch(Exception e){e.printStackTrace();} return list; }
    private Internship map(ResultSet rs)throws SQLException{ return new Internship(rs.getInt("id"),rs.getInt("company_id"),rs.getString("title"),rs.getString("field"),rs.getString("city"),rs.getString("type"),rs.getString("duration"),rs.getDouble("stipend"),rs.getString("requirements"),rs.getString("description"),rs.getString("deadline"),rs.getString("status"),rs.getString("created_at")); }
}
