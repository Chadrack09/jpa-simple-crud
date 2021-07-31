package za.ac.cput.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import za.ac.cput.dbcrud.DBCrud;
import za.ac.cput.entities.User;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 31 Jul 2021 | 12:57:31
 */
public class Registration extends HttpServlet {
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    
    PrintWriter out = response.getWriter();
    
    String uname      = request.getParameter("username");
    String password   = request.getParameter("password");
    String country    = request.getParameter("country");
    String dob        = request.getParameter("dateofbirth");
    
    out.println("Username      :" +uname);
    out.println("Password      :" +password);
    out.println("Country       :" +country);
    out.println("Date of birth :" +dob);
    
    User user = new User(uname, password, country, Date.valueOf(dob));
    DBCrud<User> crud = new DBCrud<>();
    crud.insertToDB(user);
    
    RequestDispatcher rd = request.getRequestDispatcher("/Index");
    rd.forward(request, response);
  } 

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
      doGet(request, response);
  }
}
