/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;

/**
 *
 * @author kienb
 */
public class RoleDAL extends DBContext {

    public List<Role> getAll() {
        List<Role> list = new ArrayList<>();
        try {
            String sql = "SELECT [role_id]\n"
                    + "      ,[role_name]\n"
                    + "  FROM [dbo].[role]";
            Connection con = getConnection();
            PreparedStatement ptm = con.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2));
                list.add(role);
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Role getRoleByID(int id){
        try {
            String sql = "SELECT [role_id]\n"
                    + "      ,[role_name]\n"
                    + "  FROM [dbo].[role] where role_id = ?";
            Connection con = getConnection();
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setInt(1, id);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2));
                return role;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Role getRoleByName(String name){
        try {
            String sql = "SELECT [role_id] "
                    + "  FROM [dbo].[role] where role_name = ?";
            Connection con = getConnection();
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, name);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), name);
                return role;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
