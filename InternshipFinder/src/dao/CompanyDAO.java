package dao;
import database.DBConnection;
import model.Company;
import java.sql.*;
import java.util.*;

public class CompanyDAO {
    public boolean saveOrUpdate(Company c){
        Company existing = getByEmployerId(c.getEmployerId());
        String sql = existing==null ? "INSERT INTO companies(employer_id,company_name,description,city,address,email,phone,verified) VALUES(?,?,?,?,?,?,?,?)" : "UPDATE companies SET company_name=?,description=?,city=?,address=?,email=?,phone=? WHERE employer_id=?";
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)){
            if(existing==null){ ps.setInt(1,c.getEmployerId()); ps.setString(2,c.getCompanyName()); ps.setString(3,c.getDescription()); ps.setString(4,c.getCity()); ps.setString(5,c.getAddress()); ps.setString(6,c.getEmail()); ps.setString(7,c.getPhone()); ps.setBoolean(8,c.isVerified()); }
            else { ps.setString(1,c.getCompanyName()); ps.setString(2,c.getDescription()); ps.setString(3,c.getCity()); ps.setString(4,c.getAddress()); ps.setString(5,c.getEmail()); ps.setString(6,c.getPhone()); ps.setInt(7,c.getEmployerId()); }
            return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace(); return false;}
    }
    public Company getByEmployerId(int employerId){
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM companies WHERE employer_id=?")){
            ps.setInt(1,employerId); ResultSet rs=ps.executeQuery(); if(rs.next()) return map(rs);
        }catch(Exception e){e.printStackTrace();} return null;
    }
    public Company getById(int id){
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM companies WHERE id=?")){
            ps.setInt(1,id); ResultSet rs=ps.executeQuery(); if(rs.next()) return map(rs);
        }catch(Exception e){e.printStackTrace();} return null;
    }
    public List<Company> getAll(){ List<Company> list=new ArrayList<>(); try(Connection con=DBConnection.getConnection(); Statement st=con.createStatement(); ResultSet rs=st.executeQuery("SELECT * FROM companies ORDER BY id DESC")){ while(rs.next()) list.add(map(rs)); }catch(Exception e){e.printStackTrace();} return list; }
    public boolean verify(int id, boolean status){ try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("UPDATE companies SET verified=? WHERE id=?")){ ps.setBoolean(1,status); ps.setInt(2,id); return ps.executeUpdate()>0; }catch(Exception e){e.printStackTrace();return false;} }
    private Company map(ResultSet rs)throws SQLException{ return new Company(rs.getInt("id"),rs.getInt("employer_id"),rs.getString("company_name"),rs.getString("description"),rs.getString("city"),rs.getString("address"),rs.getString("email"),rs.getString("phone"),rs.getBoolean("verified")); }
}
