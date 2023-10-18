package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class Delete1Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter pr = response.getWriter();
        String xRollno = request.getParameter("rollno");
        TeacherDAO u = new TeacherDAO();
        Teacher x = u.getTeacher(xRollno);
        if(x==null) {
           pr.println("<h2> A Teacher is not found</h2>");
           request.getRequestDispatcher("delete1.html").include(request, response);
        }
        else {
        u.delete(xRollno);
        List<Teacher> lst = u.getTeachers();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("list.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter pr = response.getWriter();
        String xRollno = request.getParameter("rollno");
        TeacherDAO u = new TeacherDAO();
        Teacher x = u.getTeacher(xRollno);
        if(x==null) {
           pr.println("<h2> A Teacher is not found</h2>");
           request.getRequestDispatcher("delete1.html").include(request, response);
        }
        else {
        u.delete(xRollno);
        List<Teacher> lst = u.getTeachers();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("list.jsp").forward(request, response);
        }

    }
}

