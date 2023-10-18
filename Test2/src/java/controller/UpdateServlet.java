package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class UpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xRollno = request.getParameter("rollno");
        TeacherDAO u = new TeacherDAO();
        Teacher x = u.getTeacher(xRollno);
        if(x==null) {
           pr.println("<h2> A Teacher is not found</h2>");
           request.getRequestDispatcher("update.html").include(request, response);
        }
        else {
           request.setAttribute("x", x);
           request.getRequestDispatcher("update.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xRollno, xName;
        xRollno = request.getParameter("rollno");
        xName = request.getParameter("name");
        boolean isOk = true;
        if(xRollno==null || xRollno.equals("")) {
           isOk = false;
        }
        if(xName==null || xName.trim().length()==0 || xName.trim().equals("Invalid name!")) {
           xName = "Invalid name!"; 
           isOk = false;
        }

        Teacher x = new Teacher(xRollno,xName);
        if(!isOk) {
          request.setAttribute("x", x);
          request.getRequestDispatcher("update.jsp").forward(request, response);
          return;
        }
        TeacherDAO u = new TeacherDAO();
        u.update(xRollno,x);
        List<Teacher> lst = u.getTeachers();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}

