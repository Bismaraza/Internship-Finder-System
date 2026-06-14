package dao;

import database.DBConnection;
import model.Employer;
import java.sql.*;

public class EmployerDAO {

    public boolean createDefault(int userId) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO employers(user_id,designation,phone) VALUES(?,?,?)"
             )) {

            ps.setInt(1, userId);
            ps.setString(2, "");
            ps.setString(3, "");

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Employer getByUserId(int userId) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM employers WHERE user_id=?"
             )) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Employer(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("designation"),
                        rs.getString("phone")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Employer getById(int id) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM employers WHERE id=?"
             )) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Employer(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("designation"),
                        rs.getString("phone")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean update(Employer e) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE employers SET designation=?, phone=? WHERE user_id=?"
             )) {

            ps.setString(1, e.getDesignation());
            ps.setString(2, e.getPhone());
            ps.setInt(3, e.getUserId());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}