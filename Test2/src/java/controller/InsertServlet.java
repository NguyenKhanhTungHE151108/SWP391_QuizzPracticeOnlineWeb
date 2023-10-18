package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class InsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xRollno,xName;
        xRollno = request.getParameter("rollno");
        xRollno = xRollno.trim();
        TeacherDAO u = new TeacherDAO();
        Teacher x = u.getTeacher(xRollno);
        if(x != null) {
           pr.print("<h3> The roll no " + xRollno + " already exists!");
           request.getRequestDispatcher("insert.html").include(request, response);
           return;
        }
        xName = request.getParameter("name");
        if(xName==null || xName.trim().length()==0) {
           pr.print("<h3> The name must not be empty!");
           request.getRequestDispatcher("insert.html").include(request, response);
           return;
         }

        x = new Teacher(xRollno,xName);
        u.insert(x);
        response.sendRedirect("list");

    }
}

