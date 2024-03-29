<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Teacher" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
  List<Teacher> lst = (List<Teacher>) request.getAttribute("lst");
%>    
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>List of Teachers</title>
  </head>
  <body>
    <h2> List of Teachers </h2>
    <table border="1">
      <tr>
        <td> Rollno </td>
        <td> Name </td>
      </tr>
      <%
        for(Teacher x: lst) {
      %>
      <tr>
        <td><%= x.getRollno() %> </td>
        <td><%= x.getName() %> </td>
      </tr>  
      <% } %>  
    </table>     
    <p><button onclick='window.history.go(-1);'>Back to previous page</button>
    <p><a href="index.html">Back to homepage</a>
  </body>
</html>
