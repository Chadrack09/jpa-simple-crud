<%-- 
    Document   : register
    Created on : 31 Jul 2021 | 12:45:57
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
    <center>
      <h1>Registration</h1>
      <table>
        <form action="Registration" method="POST">
          <tbody>
            <tr><td><input type="type" name="username" placeholder="Username" ></td></tr>
            <tr><td><input type="password" name="password" placeholder="Password" ></td></tr>
            <tr>
              <td>
                <select name="country" style="width:100%">
                  <option value="France">France</option>
                  <option value="Congo">Congo</option>
                  <option value="Italy">Italy</option>
                  <option value="Canada">Canada</option>
                </select>
              </td>
            </tr>
            <tr><td><input type="date" name="dateofbirth" style="width:97%"></td></tr>
            <tr><td><input type="submit" value="Register" style="width:100%"></td></tr>
          </tbody>
        </form>
      </table>
    </center>
  </body>
</html>
