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
    <p> <a href="search1.html"/> Search </a>
    <p> <a href="sort.jsp"/> Sort </a>
    <table border="1">
      <tr>
        <td align="center"> <a href="sort?colName='rollno'"> Rollno </a> </td>
        <td align="center"> <a href="sort?colName='name'"> Name </a> </td>
      <td  colspan="2" align="center"> <a href="insert.html"/> Insert </a> </td>
      </tr>
      <%
        for(Teacher x: lst) {
      %>
      <tr>
        <td><%= x.getRollno() %> </td>
        <td><%= x.getName() %> </td>
        <td><a href="update?rollno=<%=x.getRollno() %>">  Edit </a> </td>
        <td><a href="delete1?rollno=<%=x.getRollno() %>">  Delete </a> </td>

      </tr>  
      <% } %>  
    </table>     
    <p><button onclick='window.history.go(-1);'>Back to previous page</button>
    <p><a href="index.html">Back to homepage</a>
  </body>
</html>
