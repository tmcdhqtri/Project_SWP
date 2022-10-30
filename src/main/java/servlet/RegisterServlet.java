/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String cusUsername = request.getParameter("PHONE");
        String cusPassword = request.getParameter("CARID");
        String confirmPassword = request.getParameter("DATETEST");
        DAO dao = new DAO();
        if (cusPassword == null ? confirmPassword != null : !cusPassword.equals(confirmPassword)){}
        else{
        dao.registeredCustomer(cusName, cusPhone, cusEmail, cusAddress, cusDateOfBirth, cusUsername, cusPassword, true);
        request.setAttribute("MESSAGE2", "Success");
        RequestDispatcher rd = request.getRequestDispatcher("");
        rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
