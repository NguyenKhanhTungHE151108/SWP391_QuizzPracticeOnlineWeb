/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import Model.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MY PC
 */
public class TeacherDAO extends MyDAO{
    public List<Teachers> getTeacherList() {
    List<Teachers> t = new ArrayList<>();
    xSql = "select * from Teachers";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      int xTeacher_id;
      int xUser_id;
      Teachers x;
      while(rs.next()) {
        xTeacher_id = rs.getInt("teacher_id");  
        xUser_id = rs.getInt("user_id"); 
        x = new Teachers(xTeacher_id, xUser_id);
        t.add(x);
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    return(t);
  }
  
  public Teachers searchTeachers(int xTeacher_id) {
     Teachers x = null;
     int xUser_id;
     xSql = "select * from Teachers where teacher_id=?";
     try {
       ps = con.prepareStatement(xSql);
       ps.setInt(1,xTeacher_id);
       rs = ps.executeQuery();
        /* The cursor on the rs after this statement is in the BOF area, i.e. it is before the first record.
         Thus the first rs.next() statement moves the cursor to the first record
        */
       if(rs.next()) {
          xUser_id = rs.getInt("user_id");
          x = new Teachers(xTeacher_id, xUser_id);
        } 
        rs.close();
        ps.close();
       }
       catch(Exception e) {
        e.printStackTrace();
      }
     return(x); 
   } 
  
  public void updateByTeacherId(Teachers x) {
     xSql = "update Teachers set user_id=?  where teacher_id=?";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setInt(1, x.getUser_id());
        ps.setInt(2, x.getTeacher_id());
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
     return;
  }

  public void deleteByTeacherId(int xTeacher_id) {
     xSql = "delete from Teachers where teacher_id=?";
     try {
        ps = con.prepareStatement(xSql);
        ps.setInt(1, xTeacher_id);
        ps.executeUpdate();
        ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
  }
  
  public void insertTeachers(Teachers x) {
     xSql = "insert into Teachers values (?,?)"; 
     try {
      ps = con.prepareStatement(xSql);
      ps.setInt(1, x.getTeacher_id());
      ps.setInt(2, x.getUser_id());
      ps.executeUpdate();
      ps.close();
     }     
     catch(Exception e) {
        e.printStackTrace();
     }
  }
  
}
