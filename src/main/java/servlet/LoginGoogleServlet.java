/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import GoogleAccess.GooglePojo;
import GoogleAccess.GoogleUtils;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Login")
public class LoginGoogleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LoginGoogleServlet() {
    super();
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("code");
    if (code == null || code.isEmpty()) {
      RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");
      dis.forward(request, response);
    } else {
//      String accessToken = GoogleUtils.getToken(code);
//      GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
//      request.setAttribute("id", googlePojo.getId());
//      request.setAttribute("name", googlePojo.getName());
//      request.setAttribute("email", googlePojo.getEmail());
      
      RequestDispatcher dis = request.getRequestDispatcher("home");
      dis.forward(request, response);
    }
  }
    @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}