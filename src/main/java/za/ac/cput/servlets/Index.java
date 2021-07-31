package za.ac.cput.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 31 Jul 2021 | 11:47:59
 */
public class Index extends HttpServlet { 
    
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("Hello Home Servlet");
    
    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
    rd.forward(request, response);
  } 

  /**
   * doPost Methods
   * 
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
      doGet(request, response);
  }
}
