/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.*;
import DAO.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author MY PC
 */

public class DeleteTeacherServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        int xTeacher_id = Integer.parseInt(request.getParameter("teacher_id").trim());
        TeacherDAO u = new TeacherDAO();
        u.deleteByTeacherId(xTeacher_id);
        response.sendRedirect("techerList.jsp");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        int xTeacher_id = Integer.parseInt(request.getParameter("teacher_id").trim());
        if(xTeacher_id==0) {
           pr.print("<h3> Id cannot be empty! </h3>");
           request.getRequestDispatcher("deleteTeacher.jsp").include(request, response);
           return;
        }
        TeacherDAO u = new TeacherDAO();
        Teachers x = (Teachers) u.getTeacherList();
        if(x==null) {
           pr.print("<h3> Worker with id " + xTeacher_id + " is not found </h3>");
           request.getRequestDispatcher("deleteWorker.jsp").include(request, response);
           return;
        }
        u.deleteByTeacherId(xTeacher_id);
        response.sendRedirect("workerList.jsp");
    }
    
    

}
