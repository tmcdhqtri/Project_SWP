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
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author This PC
 */
public class LoginServlet extends jakarta.servlet.http.HttpServlet {

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        
        System.out.println("doGet");
        request.getRequestDispatcher("./Login/Login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        System.out.println("doPost");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
//        password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
//        
//        DAO dao = new DAO();
//        Customer accCus = dao.loginCustomer(username, password);
//        Personnel accPerson = dao.loginPersonnel(username, password);
//        
//        if (accCus!=null)
//        {
//            HttpSession session = request.getSession();
//            session.setAttribute("acc", accCus);
//            response.sendRedirect("home");
//        }
//        else if (accPerson != null)
//        {
//            HttpSession session = request.getSession();
//            session.setAttribute("acc", accPerson);
//            if (accPerson.getRole()==true)
//                response.sendRedirect("homeadmin");
//            else response.sendRedirect("home");
//        } 
        if (username.equals("abc") && password.equals("123"))
        {
            response.sendRedirect("home");
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
