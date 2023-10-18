package model;
import java.util.*;
import java.sql.*;
public class TeacherDAO extends MyDAO {
    
  public List<Teacher> getTeachers() {
    List<Teacher> t = new ArrayList<>();
    xSql = "select * from Teacher";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String xRollno,xName;
      Teacher x;
      while(rs.next()) {
        xRollno = rs.getString("rollno");  
        xName = rs.getString("name");  
        x = new Teacher(xRollno,xName);
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
  public Teacher getTeacher(String xRollno) {
    xSql = "select * from Teacher where rollno = ?";
      String xName;
      Teacher x = null;
    try {
      ps = con.prepareStatement(xSql);
      ps.setString(1,xRollno);
      rs = ps.executeQuery();
      if(rs.next()) {
        xName = rs.getString("name");  
        x = new Teacher(xRollno,xName);
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    return(x);
  }
  public List<Teacher> getTeachers(String xxName) {
    List<Teacher> t = new ArrayList<>();
    xSql = "select * from Teacher where name like '%" + xxName + "%'";
      String xRollno,xName;
      Teacher x;
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      while(rs.next()) {
        xRollno = rs.getString("rollno");  
        xName = rs.getString("name");  
        x = new Teacher(xRollno,xName);
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
  public void insert(Teacher x) {
     xSql = "insert into Teacher (rollno,name,mark) values (?,?,?)"; 
     try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, x.getRollno());
      ps.setString(2, x.getName());
      ps.executeUpdate();
      ps.close();
     }     
     catch(Exception e) {
        e.printStackTrace();
     }
  }
  public void delete(String xRollno) {
     xSql = "delete from Teacher where rollno=?";
     try {
        ps = con.prepareStatement(xSql);
        ps.setString(1, xRollno);
        ps.executeUpdate();
        //con.commit();
        ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
  }
  public void update(String xRollno, Teacher x) {
     xSql = "update Teacher set name=?, mark=? where rollno=?";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, x.getName());
        ps.setString(2, xRollno);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
  }
  public String [] getColNames(String xTable) {
    String [] a = new String[30];
    int i = 0; int n;
    xSql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
    try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, xTable);
      rs = ps.executeQuery();
      String xColName;
      i=0;
      while(rs.next()) {
        xColName = rs.getString("COLUMN_NAME");
        a[i++] = xColName;
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    n = i;
    String [] b = new String[n];
    for(i=0;i<n;i++) b[i] = a[i];
    return(b);
  }

  public List<Teacher> getTeachers(String xSortColName, String xSortType) {
    List<Teacher> t = new ArrayList<>();
    xSql = "select * from Teacher order by " + xSortColName + " " + xSortType;
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String xRollno,xName;
      Teacher x;
      while(rs.next()) {
        xRollno = rs.getString("rollno");  
        xName = rs.getString("name");  

        x = new Teacher(xRollno,xName);
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
}
