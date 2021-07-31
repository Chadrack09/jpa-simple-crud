package za.ac.cput.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import za.ac.cput.dbcrud.DBCrud;
import za.ac.cput.entities.User;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 31 Jul 2021 | 14:06:44
 */
public class Home extends HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    
    PrintWriter out = response.getWriter();
    out.println("This is Home Servlet");
    
    String uname    = request.getParameter("username");
    String password = request.getParameter("password");
    
    User user = new User();
    user.setUserName(uname);
    user.setUserPassword(password);
    DBCrud<User> crud = new DBCrud<>();
    
    boolean validate = crud.validate(user);
    if(validate == true) {
      request.getRequestDispatcher("/home.jsp")
              .forward(request, response);
    }
    else {
      HttpSession session = request.getSession();
      session.setAttribute("u&p", "Username and Password do not match");
      request.getRequestDispatcher("index.jsp").forward(request, response);
    }
  } 

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
      doGet(request, response);
  }
}
