<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>List of Teachers</title>
  </head>
<%
  TeacherDAO u = new TeacherDAO();
  String xTable = "Teacher";
  String [] cols = (String []) u.getColNames(xTable);
%>  
  <body>
    <h2> Sort the list of Teachers </h2>
    <form action="sort" method="POST">
       <p>Sort by: 
           <select name="colName">
              <% for(String x: cols) { %>
               <option value="<%= x %>"> <%= x %> </option>
              <% } %>
            </select>
            <p>

       <p>Sorting type:
       <input type="radio" name="sortType" value="ASC" checked/> Ascendingly
       <input type="radio" name="sortType" value="DESC" /> Descendingly
       <p><input type="submit" value="Sort"> 
    </form>  

    <p><button onclick='window.history.go(-1);'>Back to previous page</button>
    <p><a href="index.html">Back to homepage</a>
  </body>
</html>
