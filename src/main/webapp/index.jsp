<%-- 
    Document   : index
    Created on : 31 Jul 2021 | 10:14:07
    Author     : Chadrack B. Boudzoumou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <% 
      String msg = (String) session.getAttribute("u&p");
    %>
    <center>
      <h1>Login</h1>
      <table>
        <form action="Home" method="POST">
          <tbody>
            <tr><td><input type="type" name="username" placeholder="Username" ></td></tr>
            <tr><td><input type="password" name="password" placeholder="Password" ></td></tr>
            <tr><td><input type="hidden" name="admin" style="display: none"></td></tr>
            <tr><td><input type="submit" value="Login" style="width:100%"></td></tr>
          </tbody>
        </form>
      </table>
      <p style="margin: 0">Not Registered, <a href="Register">Click here</a></p>
      <p style="color:red"><%= msg %></p>
    </center>
  </body>
</html>
