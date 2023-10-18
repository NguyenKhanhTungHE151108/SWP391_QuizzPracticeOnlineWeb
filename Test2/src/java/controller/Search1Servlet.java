package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;

public class Search1Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xRollno = request.getParameter("rollno").trim();
        TeacherDAO u = new TeacherDAO();
        Teacher x = u.getTeacher(xRollno);
        if(x==null) {
          out.print("<H2> The rollno " + xRollno + " does not exist");
          request.getRequestDispatcher("search1.html").include(request, response);
        }
        else {
          request.setAttribute("x", x);
          request.getRequestDispatcher("search1.jsp").forward(request, response);
        }

    }
}

