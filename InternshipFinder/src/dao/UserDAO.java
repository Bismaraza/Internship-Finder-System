package dao;

import database.DBConnection;
import model.User;
import util.Constants;
import util.PasswordUtil;
import java.sql.*;
import java.util.*;

public class UserDAO {
    public boolean register(User user) {
        String sql = "INSERT INTO users(name,email,password,role,status,created_at) VALUES(?,?,?,?,?,NOW())";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName()); ps.setString(2, user.getEmail()); ps.setString(3, PasswordUtil.hash(user.getPassword()));
            ps.setString(4, user.getRole()); ps.setString(5, Constants.STATUS_ACTIVE);
            int rows = ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys()) { if(rs.next()) user.setId(rs.getInt(1)); }
            return rows > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
    public User login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email=? AND password=? AND status='ACTIVE'";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email); ps.setString(2, PasswordUtil.hash(password));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return map(rs);
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
    public User findById(int id) {
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM users WHERE id=?")){
            ps.setInt(1,id); ResultSet rs=ps.executeQuery(); if(rs.next()) return map(rs);
        }catch(Exception e){e.printStackTrace();} return null;
    }
    public User findByEmail(String email) {
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("SELECT * FROM users WHERE email=?")){
            ps.setString(1,email); ResultSet rs=ps.executeQuery(); if(rs.next()) return map(rs);
        }catch(Exception e){e.printStackTrace();} return null;
    }
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try(Connection con=DBConnection.getConnection(); Statement st=con.createStatement(); ResultSet rs=st.executeQuery("SELECT * FROM users ORDER BY id DESC")){
            while(rs.next()) list.add(map(rs));
        }catch(Exception e){e.printStackTrace();} return list;
    }
    public boolean updateStatus(int id, String status) {
        try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement("UPDATE users SET status=? WHERE id=?")){
            ps.setString(1,status); ps.setInt(2,id); return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace(); return false;}
    }
    private User map(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("role"), rs.getString("status"), rs.getString("created_at"));
    }
}
