/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
import com.google.common.hash.Hashing;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cusName = request.getParameter("NAME");
        String cusPhone = request.getParameter("PHONE");
        String cusEmail = request.getParameter("DES");
        String cusAddress = request.getParameter("ADDRESS");
        String cusDateOfBirth = request.getParameter("DATEOFBIRTH");
        String cusUsername = request.getParameter("USERNAME");
        String cusPassword = request.getParameter("PASSWORD");
        String confirmPassword = request.getParameter("CONFIRMPASSWORD");
        DAO dao = new DAO();
        if (cusPassword == null ? confirmPassword != null : !cusPassword.equals(confirmPassword)){}
        else{
        cusPassword = Hashing.sha256().hashString(cusPassword, StandardCharsets.UTF_8).toString();
        dao.registeredCustomer(cusName, cusPhone, cusEmail, cusAddress, cusDateOfBirth, cusUsername, cusPassword, true);
        request.setAttribute("MESSAGE2", "Success");
        RequestDispatcher rd = request.getRequestDispatcher("login");
        rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
