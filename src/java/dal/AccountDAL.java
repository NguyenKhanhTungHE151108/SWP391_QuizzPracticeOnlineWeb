/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author mjnh
 */
public class AccountDAL extends DBContext {

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try {
            String sql = "SELECT [user_id]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "      ,[email]\n"
                    + "      ,[role]\n"
                    + "      ,[dob]\n"
                    + "      ,[full_name]\n"
                    + "  FROM [dbo].[users]";
            Connection con = getConnection();
            PreparedStatement ptm = con.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(3));
                u.setDob(rs.getDate(6));
                u.setFullname(rs.getString(7));
                u.setRole(new RoleDAL().getRoleByID(5));
                list.add(u);
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public User getUserByID(int id) {
        try {
            String sql = "SELECT [user_id]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "      ,[email]\n"
                    + "      ,[role]\n"
                    + "      ,[dob]\n"
                    + "      ,[full_name]\n"
                    + "  FROM [dbo].[users] where [user_id] = ?";
            Connection con = getConnection();
            PreparedStatement ptm = con.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(3));
                u.setDob(rs.getDate(6));
                u.setFullname(rs.getString(7));
                u.setRole(new RoleDAL().getRoleByID(5));
                return u;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateAccount(int id, String fullname, String username, Date dob, String email, int roleID) {
        try {
            String sql = "UPDATE [dbo].[users]\n"
                    + "   SET [username] = ?\n"
                    + "      ,[email] = ?\n"
                    + "      ,[role] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[full_name] = ?\n"
                    + " WHERE [user_id] = ?";
            Connection con = getConnection();
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, username);
            ptm.setString(2, email);
            ptm.setInt(3, roleID);
            ptm.setTimestamp(4, new Timestamp(dob.getTime()));
            ptm.setString(5, fullname);
            ptm.setInt(6, id);
            ptm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteUser(int id) {
        try {
            String sql = "DELETE FROM [dbo].[users]\n"
                    + "      WHERE [user_id] = ?";
            Connection con = getConnection();
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setInt(1, id);
            ptm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean createAccount(String fullname, String username, Date dob, String email, int roleID, String password) {
        try {
            String sql = "INSERT INTO [dbo].[users]\n"
                    + "           ([username]\n"
                    + "           ,[password]\n"
                    + "           ,[email]\n"
                    + "           ,[role]\n"
                    + "           ,[dob]\n"
                    + "           ,[full_name])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            Connection con = getConnection();
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, username);
            ptm.setString(2, password);
            ptm.setString(3, email);
            ptm.setInt(4, roleID);
            ptm.setTimestamp(5,  new Timestamp(dob.getTime()));
            ptm.setString(6, fullname);
            int executeUpdate = ptm.executeUpdate();
            return executeUpdate > 0;
        } catch (Exception ex) {
            Logger.getLogger(AccountDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static void main(String[] args) {
        AccountDAL  dal = new AccountDAL();
        List<User> list = dal.getAll();
        for (User o : list) {
            System.out.println(o);
            
        }
        
    }
}
