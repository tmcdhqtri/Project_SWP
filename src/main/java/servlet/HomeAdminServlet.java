/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;
import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class HomeAdminServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DAO dao = new DAO();
        int countAdmin = dao.countAdmin();
        int countStaff = dao.countStaff();
        int countCustomer = dao.countCustomer();
        int countFood = dao.countFood();
        request.setAttribute("COUNTADMIN", countAdmin);
        request.setAttribute("COUNTSTAFF", countStaff);
        request.setAttribute("COUNTCUSTOMER", countCustomer);
        request.setAttribute("COUNTFOOD", countFood);
        request.getRequestDispatcher("./AdminPage/adminPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
