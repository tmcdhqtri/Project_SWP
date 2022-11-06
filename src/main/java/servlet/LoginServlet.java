/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
import Model.Customer;
import Model.Personnel;
import com.google.common.hash.Hashing;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author This PC
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        
        request.getRequestDispatcher("./Login/Login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        System.out.println("doPost");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username);
        
        password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        System.out.println("password: " + password);
        
        DAO dao = new DAO();
        Customer accCus = dao.loginCustomer(username, password);
        Personnel accPerson = dao.loginPersonnel(username, password);
        
        if (accCus!=null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("acc", accCus);
            response.sendRedirect("home");
        }
        else if (accPerson != null)
        {
            System.out.println("accPerson");
            HttpSession session = request.getSession();
            session.setAttribute("acc", accPerson);
            if (accPerson.getRole()==false)
                response.sendRedirect("homeAdmin");
            else response.sendRedirect("home");
        }
        else
        {

            String message = "Wrong username or password";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/Login/Login.jsp").forward(request, response);
        }  
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
